package com.kiseki.test;

import org.junit.Test;
import org.redisson.api.RHyperLogLog;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ClusterTest extends BaseTest{

    @Test
    public void test() throws Exception{
        RHyperLogLog<Object> a = redissonClient.getHyperLogLog("a");
        boolean fada = a.add("fada");

        while (true){
            try {
                redissonClient.getBucket("test"+System.currentTimeMillis()).set("test", 1, TimeUnit.SECONDS);
                System.out.println(LocalDateTime.now().toString() + ":ok");
            }catch (Exception e){
                System.out.println(LocalDateTime.now().toString() + ":error");
            }finally {
                Thread.sleep(1000);
            }
        }
    }
}