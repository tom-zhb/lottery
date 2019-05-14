package com.bc.lottery.tenant.controller;

import com.bc.lottery.common.cache.redis.CacheEnum;
import com.bc.lottery.common.cache.redis.RedisUtils;
import com.bc.lottery.common.core.api.R;
import com.bc.lottery.common.domain.tenant.TenantAdmin;
import com.bc.lottery.common.service.tenant.TenantAdminService;
import com.bc.lottery.common.vo.TenantAdminVO;
import com.bc.lottery.tenant.cookie.CookieManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(maxAge = 60 * 60 * 24)
@RestController
@RequestMapping(value = "/admin")
public class TenantAdminController {
    @Resource
    TenantAdminService tenantAdminService;

    @Resource
    RedisUtils redisUtils;

    @PostMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @PostMapping(value="/signin")
    public R<TenantAdminVO> login(HttpServletRequest req, HttpServletResponse response,
                                  @RequestParam("userName") String userName,
                                  @RequestParam("password") String password,
                                  @RequestParam("captcha") String captcha,
                                  @RequestParam("captchaToken") String captchaToken) {

        String sessionIDKey = CookieManager.getLoginCookieValue(req);
        if (StringUtils.isNotEmpty(sessionIDKey)) {
            String sessionID = redisUtils.get(sessionIDKey);
            if (StringUtils.isNotEmpty(sessionID)) {
                return R.success("登录成功");
            }
        }

        if (StringUtils.isEmpty(userName)) {
            return R.fail("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return R.fail("密码不能为空");
        }
        if (StringUtils.isEmpty(captchaToken) || StringUtils.isEmpty(captcha)) {
            return R.fail("验证码授权失败");
        }

        String captchCode = redisUtils.get(CacheEnum.CAPTHCA.buildCacheKey(captchaToken));
        if (!StringUtils.equals(captcha, captchCode)) {
            return R.fail("验证码错误或失效");
        }

        TenantAdminVO tenantAdminVO = tenantAdminService.login(userName, password);
        if (tenantAdminVO == null) {
            return R.fail("用户名或密码不正确");
        }
        CookieManager.addLoginCookie(response, tenantAdminVO.getSessionIDKey());
        return R.success("登录成功");
    }


    @PostMapping(value="/logout")
    public R<TenantAdminVO> logout(@RequestParam("sessionID") String sessionID) throws Exception {
        boolean flag = tenantAdminService.logout(sessionID);
        if (flag) {
            return R.success("注销成功");
        }
        return R.fail("注销失败");
    }

    @GetMapping("/list")
    public R<List<TenantAdmin>> listTenantAdmins(){
        return R.data(tenantAdminService.listTenantAdmins());
    }

    @PostMapping("/add")
    public R addTenantAdmin(TenantAdmin tenantAdmin){
        int flag = tenantAdminService.save(tenantAdmin);
        if (flag > 0) {
            return R.success("添加成功");
        }
        return R.fail("添加失败");
    }
}
