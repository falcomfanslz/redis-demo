package com.kiseki.test;

import org.junit.Test;
import org.redisson.api.RBloomFilter;

public class BloomFilterTest extends BaseTest{
    @Test
    public void test(){
        this.flushdb();

        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloom-test2");
        bloomFilter.tryInit(1500, 0.03);
        for(int i = 0; i < 1000; i++){
            bloomFilter.add("a" + i);
        }

        int count = 0;

        for(int i = 0; i < 1000; i++){
            boolean contains = bloomFilter.contains("b" + i);
            if(contains){
                System.out.println("b" + i);
                count++;
            }
        }
        System.out.println(count);
    }
}
