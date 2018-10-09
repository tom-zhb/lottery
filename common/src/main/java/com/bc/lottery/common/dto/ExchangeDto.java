package com.bc.lottery.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExchangeDto implements Serializable {
    private final static Object[] S_RESULT = {0, "OK"};
    private static final long serialVersionUID = -4504020010256236026L;
    private Object msg;
    private String msgid;
    private Object[] RESULT = S_RESULT;
    private String userid;
    private String roomid;
    private String timestamp = new Date().getTime() + "";

    public ExchangeDto(String msgid, String userid, String roomid, Object msg) {
        this.msg = msg;
        this.msgid = msgid;
        this.userid = userid;
        this.roomid = roomid;
    }

}





