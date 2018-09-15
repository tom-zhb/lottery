package com.bc.lottery.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientEventInfo {
    private Long userid;
    private Integer role;
    private Long msgid;
}
