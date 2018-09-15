package com.bc.lottery.utils.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GuavaCache {
    public static final String NULL_VALUE = "nil";

    private static class GuavaCacheHolder {
        public final static Cache<String, String> instance = CacheBuilder.newBuilder()
                //设置cache的初始大小为1000，支撑1000教室
                .initialCapacity(1000)
                //设置并发数为1000，即同一时间最多只能有1000个线程往cache执行写入操作
                .concurrencyLevel(1000)
                //设置cache中的数据在写入之后的存活时间为12小时
                .expireAfterWrite(12, TimeUnit.HOURS)
                //构建cache实例
                .build();
    }

    public static Cache<String, String> getCache() {
        return GuavaCacheHolder.instance;
    }
}
