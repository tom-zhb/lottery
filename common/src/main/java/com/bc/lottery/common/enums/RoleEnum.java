package com.bc.lottery.common.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMINISTRATOR(0, "管理员"),

    SUPER_ADMINISTRATOR(1, "超级管理员");

    private int role;
    private String roleName;
    RoleEnum(int role, String roleName) {
        this.role = role;
        this.roleName = roleName;
    }
}
