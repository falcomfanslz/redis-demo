
package com.kiseki.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SentinelTest extends BaseTest{
    @Test
    public void test() throws Exception{
        while (true){
            try {
                redissonClient.getBucket("test"+System.currentTimeMillis()).set("test", 1, TimeUnit.SECONDS);
                System.out.println(LocalDateTime.now().toString() + ":ok");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(LocalDateTime.now().toString() + ":error");
            }finally {
                Thread.sleep(1000);
            }
        }
    }
}