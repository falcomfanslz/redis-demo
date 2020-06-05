package com.kiseki.test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MaxMemoryTest extends BaseTest{
    private static final Integer BYTE_SIZE = 1024 * 100;
    @Test
    public void test(){
//        this.flushdb();
        byte[] byte1 = new byte[BYTE_SIZE];
        for(int i = 0 ; i < 100; i ++){
            System.out.println(i);
            redissonClient.getBucket("byte" + i).set(byte1, 100 - i, TimeUnit.MINUTES);
//            if(i % 2 == 1){
//                for(int j = 0; j < 100 - i; j++){
//                    redissonClient.getBucket("byte" + i).get();
//                }
//            }
        }
    }
}
