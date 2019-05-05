package com.bc.lottery.tenant.cookie;

import com.bc.lottery.common.cache.redis.RedisUtils;
import com.bc.lottery.common.util.CookieUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
    public static final String TENANT_ADMIN_LOGIN_SESSION = "LOGIN_SESSION";

    @Resource
    RedisUtils redisUtils;

    public static void addLoginCookie(HttpServletResponse response, String value) {
        CookieUtils.set(response, TENANT_ADMIN_LOGIN_SESSION, value, false);
    }

    public static String getLoginCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (!ArrayUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie != null) {
                    if (TENANT_ADMIN_LOGIN_SESSION.equals(cookie.getName())) {
                        return CookieUtils.getValue(request, TENANT_ADMIN_LOGIN_SESSION);
                    }
                }
            }
        }
        return null;
    }

}
