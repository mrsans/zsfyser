package com.thunisoft.zsfy.constant;

import sun.management.Sensor;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author ZhPJ
 * @Date 2019/1/16 001611:10
 * @Version 1.0
 * @Description:
 */
public enum ConstantRedisExpire {

    /**
     * 一天
     */
    ONE_DAY(TimeUnit.DAYS.toSeconds(1)),
    /**
     * 两天
     */
    TWO_DAYS(TimeUnit.DAYS.toSeconds(2)),
    /**
     * 三天
     */
    THREE_DAYS(TimeUnit.DAYS.toSeconds(3)),
    /**
     * 四天
     */
    FOUR_DAYS(TimeUnit.DAYS.toSeconds(4)),
    /**
     * 五天
     */
    FIVE_DAYS(TimeUnit.DAYS.toSeconds(5)),
    /**
     * 六天
     */
    SIX_DAYS(TimeUnit.DAYS.toSeconds(6)),
    /**
     * 七天
     */
    SEVEN_DAYS(TimeUnit.DAYS.toSeconds(7)),

    /*分钟*/
    ONE_MINUTE(TimeUnit.MINUTES.toSeconds(1)),
    TWO_MINUTES(TimeUnit.MINUTES.toSeconds(2)),
    FIVE_MINUTES(TimeUnit.MINUTES.toSeconds(5)),
    TEN_MINUTES(TimeUnit.MINUTES.toSeconds(10)),
    THIRTY_MINUTES(TimeUnit.MINUTES.toSeconds(30));

    private long seconds;

    ConstantRedisExpire(long seconds) {
        this.seconds = seconds;
    }

    public long ofSeconds() {
        return seconds;
    }

}
