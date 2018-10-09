package com.bc.lottery.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class SignalDto implements Serializable {
    private static final long serialVersionUID = -5908309919311062854L;
    private String userid;
    private String roomid;
    private String role;
    private String alias;
    private String msgid;
    private Map<String,Object> msg;

}





