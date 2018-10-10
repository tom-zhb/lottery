package com.bc.lottery.common.domain.lottery.kuaisan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KuaiSan {
    public String issue;
    public Date openTime;
    public String number;
    private Date createTime;
}
