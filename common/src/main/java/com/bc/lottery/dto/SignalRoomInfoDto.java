package com.bc.lottery.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SignalRoomInfoDto implements Serializable {
    private static final long serialVersionUID = -8201879177817372205L;
    private String boarddata = "";
    private String ppt;
    private String roomid;
    private Long time;
    private List<SignalUserInfoDto> userlist;
    private Integer usernum;
}
