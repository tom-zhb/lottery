package com.bc.lottery.common.service.tenant;

import com.bc.lottery.common.cache.redis.CacheEnum;
import com.bc.lottery.common.cache.redis.RedisUtils;
import com.bc.lottery.common.domain.tenant.Tenant;
import com.bc.lottery.common.domain.tenant.TenantAdmin;
import com.bc.lottery.common.mapper.tenant.TenantAdminMapper;
import com.bc.lottery.common.mapper.tenant.TenantMapper;
import com.bc.lottery.common.util.TokenUtils;
import com.bc.lottery.common.vo.TenantAdminVO;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TenantAdminService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TenantMapper tenanMapper;

    @Resource
    private TenantAdminMapper tenantAdminMapper;

    @Resource
    private RedisUtils redisUtils;

    public int save(TenantAdmin tenantAdmin) {
        return tenantAdminMapper.insert(tenantAdmin);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public TenantAdminVO login(String userName, String password) {
        TenantAdmin tenantAdmin = tenantAdminMapper.getTenantAdmin(userName, password);
        TenantAdminVO vo = null;
        if (tenantAdmin != null) {
            // 缓存30分钟
            String sessionIDKey = DigestUtils.md5DigestAsHex(CacheEnum.TENANT_ADMIN_LOGIN_SESSION.
                    buildCacheKey(tenantAdmin.getId() + "").getBytes());
            redisUtils.setEx(sessionIDKey, TokenUtils.generateValue(), CacheEnum.TENANT_ADMIN_LOGIN_SESSION.getTimeout(), TimeUnit.MINUTES);

            vo = new TenantAdminVO();
            vo.setNickname(tenantAdmin.getNickname());
            vo.setUserName(tenantAdmin.getUserName());
            vo.setSessionIDKey(sessionIDKey);
        }
        return vo;
    }

    /**
     * 退出
     * @return
     */
    public boolean logout(String sessionID) {
        String tenantAdminJSON = redisUtils.get(sessionID);
        if (StringUtils.isNotEmpty(tenantAdminJSON)) {
            redisUtils.delete(sessionID);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public List<TenantAdmin> listTenantAdmins(){
        return tenantAdminMapper.selectAll();
    }

}
