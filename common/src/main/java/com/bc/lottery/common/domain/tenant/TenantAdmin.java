package com.bc.lottery.common.domain.tenant;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;


@NoArgsConstructor
@Data
@Table(name = "tenant_admin")
public class TenantAdmin {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String nickname;
    private String mobile;
    // 1:超级管理员， 0:普通管理员
    private int role;
    // 1:正常，0:禁用
    private int state;

    // 注册时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date regTime;
    // 最后登录时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

}
