package com.bc.lottery.common.domain.tenant;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@NoArgsConstructor
@Data
@Table(name = "tenant_admin")
public class TenantAdmin {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名至少4位最多10位")
    private String userName;

    @Email
    private String email;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 15, message = "密码长度至少8位最多15位")
    private String password;

    @NotBlank(message = "昵称不能为空")
    private String nickname;

    private String mobile;

    // 1:超级管理员， 0:普通管理员
    @Range(min = 0, max = 1, message = "role必须是0或1")
    private Integer role;

    // 1:正常，0:禁用
    @Range(min = 0, max = 1, message = "state必须是0或1")
    private Integer state;

    // 注册时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date regTime;

    // 最后登录时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastLoginTime;

}
