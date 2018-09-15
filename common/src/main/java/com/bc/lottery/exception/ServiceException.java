package com.bc.lottery.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -8634700792767837033L;

    public ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
