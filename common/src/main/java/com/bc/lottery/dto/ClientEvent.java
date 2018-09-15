package com.bc.lottery.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data

public class ClientEvent implements Serializable {

    private static final long serialVersionUID = -5648191925221017056L;
    private Integer type;
    private Date createTime;
    private String roomId;
    private BigInteger timeOffset = BigInteger.valueOf(0);
    private Date clientEventCreateTime;
//    private Date clientEventLocalTime;
    private String data = "";
}
