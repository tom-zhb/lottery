package com.bc.lottery.enums;

public interface LotteryTypeEnum {

    public enum KuaiSan {
        HUBEI(1);
        private int type;
        KuaiSan(int type) {
            this.type = type;
        }

    }
}
