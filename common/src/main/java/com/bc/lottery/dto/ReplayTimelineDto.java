package com.bc.lottery.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplayTimelineDto {
    private String roomId;
    private BigInteger timeOffset;
    private Date clientEventCreateTime;
//    private BigInteger timeOffsetNew;
//    private Date clientEventServerTime;
    private String data = "";
}
