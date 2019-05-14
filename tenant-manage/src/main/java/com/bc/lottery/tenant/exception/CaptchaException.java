package com.bc.lottery.tenant.exception;

import lombok.Getter;
import lombok.Setter;

public class CaptchaException extends Exception {
    @Getter
    @Setter
    protected String message;

    public CaptchaException() {
        setMessage("verification code generation failed");
    }

    public CaptchaException(String message) {
        this.message = message;
    }
}
