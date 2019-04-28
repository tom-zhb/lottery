package com.bc.lottery.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonResultModel {
    // 成功
    private static final int SUCESS_CODE = 1;
    private static final String SUCESS_MSG = "sucess";
    // 失败
    private static final int FAIL_CODE = 0;
    private static final String FAIL_MSG = "fail";

    private static final JsonResultModel SUCESS = sucess(null);
    private static final JsonResultModel FAIL = fail(null);
    // 返回码
    private Integer code;
    // 返回信息提示
    private String msg;
    // 返回的数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static JsonResultModel sucess(String msg, Object data) {
        return new JsonResultModel(SUCESS_CODE, msg, data);
    }

    public static JsonResultModel sucess(String msg) {
        return sucess(msg, null);
    }

    public static JsonResultModel sucess(Object data) {
        return sucess(SUCESS_MSG, data);
    }

    public static JsonResultModel sucess() {
        return SUCESS;
    }


    public static JsonResultModel fail(String msg, Object data) {
        return new JsonResultModel(FAIL_CODE, msg, data);
    }

    public static JsonResultModel fail(String msg) {
        return fail(msg, null);
    }

    public static JsonResultModel fail(Object data) {
        return fail(FAIL_MSG, data);
    }

    public static JsonResultModel fail() {
        return FAIL;
    }
}
