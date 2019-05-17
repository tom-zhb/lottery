package com.bc.lottery.common.enums;

import lombok.Getter;

@Getter
public enum StateEnum {
    FORBIDDEN(0, "禁用"),
    NORMAL(1, "正常");

    private int role;
    private String roleName;
    StateEnum(int role, String roleName) {
        this.role = role;
        this.roleName = roleName;
    }
}
