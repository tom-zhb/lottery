package com.bc.lottery.common.domain.tenant;

import lombok.*;

import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@Data
@Table(name = "tenant")
public class Tenant {
    private Long id;
    private String name;
    private String remark;
    private Date createTime;
}
