package com.bc.lottery.tenant.exception;

import com.bc.lottery.common.core.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 验证码异常处理
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(CaptchaException.class)
    @ResponseBody
    public R<String> captchaExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseBody
    public R<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public R<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    @ResponseBody
    public R<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R<String> exceptionHandler(HttpServletRequest request, Exception exception) {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    private R<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
        logger.error(message, exception);
        return R.fail(message);
    }
}