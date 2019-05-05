package com.bc.lottery.common.domain.tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;


@NoArgsConstructor
@Data
@Table(name = "tenant")
public class TenantAdmin {
    private Long id;
    private String userName;
    private String password;
    private String nickame;
    // 超级管理员， 0:普通管理员
    private int role;
    // 注册时间
    private Date regTime;
    // 最后登录时间
    private Date lastLoginTime;

}
