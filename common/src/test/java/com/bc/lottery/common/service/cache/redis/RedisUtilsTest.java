package com.bc.lottery.common.service.cache.redis;

import com.bc.lottery.common.cache.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {
    @Resource
    RedisUtils redisUtils;

    @Test
    public void test() {
        //System.out.println("11111111111");
        //redisUtils.setEx("a", "11111", 30, TimeUnit.SECONDS);
        String value = redisUtils.get("a");
        System.out.println("============" + value);
    }
}
