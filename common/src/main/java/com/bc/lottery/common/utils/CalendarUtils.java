package com.bc.lottery.common.utils;

import java.util.Calendar;

public final class CalendarUtils {

    public static final Calendar createCalendar(int hourOfDay, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DATE), hourOfDay, minute, second);
        return date;
    }
}
