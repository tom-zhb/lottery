package com.bc.lottery.common.service.tenant;

import com.bc.lottery.common.domain.tenant.TenantDO;
import com.bc.lottery.common.mapper.tenant.TenantAdminMapper;
import com.bc.lottery.common.mapper.tenant.TenantMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TenantService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TenantMapper tenanMapper;

    @Resource
    private TenantAdminMapper tenantAdminMapper;

    public int save(TenantDO tenant) {
        return tenanMapper.insert(tenant);
    }

    public boolean login(String userName, String password) {
        return tenantAdminMapper.getTenantAdminDO(userName, password) == null ? true : false;
    }
}
