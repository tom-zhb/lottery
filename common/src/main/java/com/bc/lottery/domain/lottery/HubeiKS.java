package com.bc.lottery.domain.lottery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "hubei_ks")
public class HubeiKS extends KuaiSan {
    private String issue;
    private String openTime;
    private String number;
}
