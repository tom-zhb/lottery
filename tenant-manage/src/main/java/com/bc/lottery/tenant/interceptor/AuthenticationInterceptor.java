package com.bc.lottery.tenant.interceptor;

import com.bc.lottery.common.cache.redis.CacheEnum;
import com.bc.lottery.common.cache.redis.RedisUtils;
import com.bc.lottery.common.util.CookieUtils;
import com.bc.lottery.tenant.cookie.CookieManager;
import com.bc.lottery.tenant.exception.SessionNotFoundException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisUtils redisUtils;


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws IOException {
        String sessionIDKey = CookieManager.getLoginCookieValue(req);
        if (StringUtils.isNotEmpty(sessionIDKey)) {
            String sessionID = redisUtils.get(sessionIDKey);
            if (StringUtils.isNotEmpty(sessionID)) {
                redisUtils.expire(sessionIDKey, CacheEnum.TENANT_ADMIN_LOGIN_SESSION.getTimeout(),
                        CacheEnum.TENANT_ADMIN_LOGIN_SESSION.getTimeUnit());
                return true;
            }
        }
        res.sendRedirect(req.getContextPath() + "/admin/login");
        return false;
        //returnJson(res, JSON.toJSONString(R.fail("session expire")));
        //throw new SessionNotFoundException("session expire");
        //return false;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) throws Exception {

    }


    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            logger.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
