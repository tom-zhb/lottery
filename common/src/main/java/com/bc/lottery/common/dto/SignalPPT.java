package com.bc.lottery.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignalPPT implements Serializable {
    private static final long serialVersionUID = -2472425993632639501L;
    private String docId = "";
    private Integer page;
    private Integer slideCount = 0;
}
