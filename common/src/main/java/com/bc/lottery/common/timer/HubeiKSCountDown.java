package com.bc.lottery.common.timer;

import com.bc.lottery.common.enums.LotteryTypeEnum.KuaiSan;

public class HubeiKSCountDown extends CountDownTimer {

    @Override
    CountDownParam getCountDownParam() {
        return CountDownConfiguration.getCountDownParam(KuaiSan.HUBEI);
    }

}
