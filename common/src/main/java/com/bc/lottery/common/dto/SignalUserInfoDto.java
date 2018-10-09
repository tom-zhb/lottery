package com.bc.lottery.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignalUserInfoDto implements Serializable {

    private static final long serialVersionUID = -278266745248879599L;
    private String alias;
    private String camera_status;
    private String online;
    private String role;
    private String starnum;
    private String streamurl;
    private String userid;
}
