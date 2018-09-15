package com.bc.lottery.core.annotation.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Autowired
    //private TokenAuthService tokenAuthService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       /* // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要加了该注解
        TokenAuth methodAnnotation = method.getAnnotation(TokenAuth.class);
        // 没有声明需要权限,或者声明不验证权限
        if (methodAnnotation == null) {
            return true;
        } else {

            String authorization = "Authorization";
            String accessToken = request.getHeader(authorization);
           *//* if (Strings.isNullOrEmpty(accessToken)) {
                accessToken = request.getParameter("token");
            }*//*
            if (Strings.isNullOrEmpty(accessToken)) {
                throw new ServiceException(ErrorCode.UNAUTHORIZED, "no token ");
            }

            logger.debug("accessToken=========>>>>{}", accessToken);
            Account account = tokenAuthService.verifyTokenAndAccountStatusCache(accessToken.replace("Bearer", "").trim());
            if (account == null) {
                throw new ServiceException(ErrorCode.UNAUTHORIZED, "Invalid user ");
            }

            logger.debug("account id=========>>>>{}", account.getId());
            ThreadLocalContext.reset();
            ThreadLocalContext.put(Constants.ACCOUNT, account);
            return true;
        }*/

        return false;
    }


}
