package com.kiseki.test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MaxMemoryTest extends BaseTest{
    private static final Integer BYTE_SIZE = 1024 * 100;
    @Test
    public void test(){
        redissonClient.getKeys().flushdb();
        byte[] byte1 = new byte[BYTE_SIZE];
        for(int i = 0 ; i < 20; i ++){
            System.out.println(i);
            redissonClient.getBucket("byte" + i).set(byte1, i + 1, TimeUnit.SECONDS);
            if(i < 10){
                redissonClient.getBucket("byte" + i).get();
            }
        }
    }
}
