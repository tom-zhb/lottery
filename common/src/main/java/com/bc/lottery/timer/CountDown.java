package com.bc.lottery.timer;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown {
    private int curSec;

    public CountDown(int limitSec) throws InterruptedException {
        curSec = limitSec;
        System.out.println("count down from " + limitSec + " s ");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                if (curSec == 0) {
                    curSec = limitSec;
                }
                System.out.println("Time remians " + --curSec + " s");
            }
        }, 0, 1000);

       /* TimeUnit.SECONDS.sleep(limitSec);
        //timer.cancel();*/
        //System.out.println("Time is out!");
    }

    //Test
    public static void main(String[] args) throws InterruptedException {
        new CountDown(10);
    }

}
