package com.bc.lottery.domain.lottery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class KuaiSan {
    public String issue;
    public Date openTime;
    public String number;
    private Date updateTime;
}
