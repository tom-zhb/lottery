package com.bc.lottery.common.enums;

import com.bc.lottery.common.util.CalendarUtils;
import lombok.Getter;

import java.util.Calendar;

public interface LotteryTypeEnum {

    @Getter
    public enum KuaiSan implements  LotteryTypeEnum {
        HUBEI(1, CalendarUtils.createCalendar(8, 40, 0), CalendarUtils.createCalendar(22, 0, 0), 60 * 10),
        HEBEI(2, CalendarUtils.createCalendar(8, 40, 0), CalendarUtils.createCalendar(22, 0, 0), 60 * 10);
        private int type;
        private Calendar startDate;
        private Calendar endDate;
        private int timeInterval;
        KuaiSan(int type, Calendar startDate, Calendar endDate, int timeInterval) {
            this.type = type;
            this.startDate = startDate;
            this.endDate = endDate;
            this.timeInterval = timeInterval;
        }

    }
}
