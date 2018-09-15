package com.bc.lottery.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonResultModel {
    private final static Integer DEFAULT_CODE = 200;
    private final static String DEFAULT_MSG = "success";

    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    private final static JsonResultModel SUCCESS = new JsonResultModel(DEFAULT_CODE, DEFAULT_MSG, null);

    public static JsonResultModel newJsonResultModel(Object data) {
        return new JsonResultModel(DEFAULT_CODE, DEFAULT_MSG, data);
    }

    public static JsonResultModel Success() {
        return SUCCESS;
    }
}
