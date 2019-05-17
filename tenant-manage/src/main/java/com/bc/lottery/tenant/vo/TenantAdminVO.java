package com.bc.lottery.tenant.vo;

import com.bc.lottery.common.domain.tenant.TenantAdmin;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class TenantAdminVO extends TenantAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleName;
    private String stateName;
}
