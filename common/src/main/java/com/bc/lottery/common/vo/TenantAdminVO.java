package com.bc.lottery.common.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Data
public class TenantAdminVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String nickname;
    // 余额
    //private BigDecimal balance;
    // 头像url
    //private String avatarURL;
    // 是否是代理
    //private boolean agent;
    private String sessionIDKey;
}
