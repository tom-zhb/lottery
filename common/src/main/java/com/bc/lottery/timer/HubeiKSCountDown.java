package com.bc.lottery.timer;

import com.bc.lottery.enums.LotteryTypeEnum.KuaiSan;

public class HubeiKSCountDown extends CountDownTimer {

    @Override
    CountDownParam getCountDownParam() {
        return CountDownConfiguration.getCountDownParam(KuaiSan.HUBEI);
    }

}
