package com.kiseki.test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MaxMemoryTest extends BaseTest{
    private static final Integer BYTE_SIZE = 1024 * 100;
    @Test
    public void test(){
        this.flushdb();
        byte[] byte1 = new byte[BYTE_SIZE];
        for(int i = 0 ; i < 100; i ++){
            redissonClient.getBucket("byte" + i).set(byte1, 100 - i, TimeUnit.MINUTES);
            System.out.println(i);
        }
    }
}
