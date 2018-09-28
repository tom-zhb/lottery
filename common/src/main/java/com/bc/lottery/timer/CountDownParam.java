package com.bc.lottery.timer;

import lombok.*;

import java.util.Calendar;


@Setter
@Getter
@Builder
@ToString
public class CountDownParam {
    private Calendar startDate;
    private Calendar endDate;
    // 倒计时间隔
    private int timeInterval;

}
