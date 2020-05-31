package com.kiseki.test;

import org.junit.Test;
import org.redisson.api.RBucket;

public class MaxMemoryTest extends BaseTest{
    private static final Integer BYTE_SIZE = 1024 * 1024 * 2;
    @Test
    public void test(){
        byte[] byte1 = new byte[BYTE_SIZE];
        byte[] byte2 = new byte[BYTE_SIZE];
        byte[] byte3 = new byte[BYTE_SIZE];
        redissonClient.getBucket("byte1").set(byte1);
        redissonClient.getBucket("byte2").set(byte2);
        redissonClient.getBucket("byte3").set(byte3);
        redissonClient.getBucket("byte4").set(byte3);
        redissonClient.getBucket("byte5").set(byte3);
        redissonClient.getBucket("byte6").set(byte3);
        redissonClient.getBucket("byte7").set(byte3);
        redissonClient.getBucket("byte8").set(byte3);
    }
}
