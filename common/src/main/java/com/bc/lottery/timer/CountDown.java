package com.bc.lottery.timer;

import lombok.Getter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Getter
public class CountDown {
    public long curSec;

    public CountDown(Calendar startDate, Calendar endDate, int timeInterval) {
        curSec = calculateCurSec(startDate, endDate, timeInterval);
        System.out.println("count down from " + timeInterval + " s ");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                if (System.currentTimeMillis() >= endDate.getTimeInMillis()) {
                    timer.cancel();
                    return;
                }
                if (curSec <= 0) {
                    curSec = calculateCurSec(startDate, endDate, timeInterval);
                }
                System.out.println("Time remians " + --curSec + " s");
            }
        }, startDate.getTime(), 1000);
    }

    private long calculateCurSec(Calendar startDate, Calendar endDate, int timeInterval) {
        if (endDate.getTimeInMillis() > startDate.getTimeInMillis()) {
            long endDateSec = endDate.getTime().getTime() / 1000;
            long curDateSec = new Date().getTime() / 1000;
            if (endDateSec - curDateSec < timeInterval) {
                return endDateSec - curDateSec;
            } else {
                return (endDateSec - curDateSec) % timeInterval > 0 ? (endDateSec - curDateSec) % timeInterval : timeInterval;
            }
        } else {
            return 0L;
        }
    }

    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH),
                startDate.get(Calendar.DATE), 19, 40, 0);

        Calendar endDate = Calendar.getInstance();
        endDate.set(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH),
                endDate.get(Calendar.DATE), 19, 56, 0);

       /* Date startDate = DateUtils.parseDate("2018-09-28 17:20:00", "yyyy-MM-dd HH:mm:ss");
        Date endDate = DateUtils.parseDate("2018-09-28 17:27:00", "yyyy-MM-dd HH:mm:ss");*/
        new CountDown(startDate, endDate, 60);
    }

}
