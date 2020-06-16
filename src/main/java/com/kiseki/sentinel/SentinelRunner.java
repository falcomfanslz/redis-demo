
package com.kiseki.sentinel;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

//@Component
public class SentinelRunner implements ApplicationRunner{

    @Autowired
    RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
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