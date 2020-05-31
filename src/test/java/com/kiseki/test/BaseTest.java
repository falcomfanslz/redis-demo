package com.kiseki.test;

import com.kiseki.MainApplication;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class BaseTest {
    @Autowired
    protected RedissonClient redissonClient;
}
