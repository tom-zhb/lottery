package com.bc.lottery.tenant.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterVo {

    public String userName;
    public String password;
    public String captcha;

}
