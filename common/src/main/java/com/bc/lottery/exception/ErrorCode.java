package com.bc.lottery.exception;

public enum ErrorCode {

	BAD_REQUEST(400, 400), UNAUTHORIZED(401, 401), FORBIDDEN(403, 403), INTERNAL_SERVER_ERROR(500, 500),

	STATUS_WRONG(1100, 400), OWNERSHIP_WRONG(1101, 403), NO_TOKEN(1102, 401), REDIS_KEY_NOT_FOUND(1104, 404);

	public int code;
	public int httpStatus;

	ErrorCode(int code, int httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
	}

}
