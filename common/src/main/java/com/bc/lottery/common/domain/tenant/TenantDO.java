package com.bc.lottery.common.domain.tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tenant")
public class TenantDO {
    private Long id;
    private String name;
    private String remark;
    private Date createTime;
}
