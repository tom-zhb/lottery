package com.bc.lottery.common.timer;


import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.common.enums.LotteryTypeEnum.KuaiSan;
import com.bc.lottery.common.utils.mapper.JsonMapper;

import java.util.HashMap;
import java.util.Map;

public class CountDownConfiguration {
    private static final Map<LotteryTypeEnum, CountDownParam> map = new HashMap<>();

    static {
        // 快三
        map.put(KuaiSan.HUBEI, CountDownParam.builder().startDate(KuaiSan.HUBEI.getStartDate()).endDate(KuaiSan.HUBEI.getEndDate()).timeInterval(KuaiSan.HUBEI.getTimeInterval()).build());
    }

    public static CountDownParam getCountDownParam(LotteryTypeEnum lotteryTypeEnum) {
        if (lotteryTypeEnum != null) {
            return map.get(lotteryTypeEnum);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(JsonMapper.defaultMapper().toJson(getCountDownParam(KuaiSan.HUBEI)));
    }
}
