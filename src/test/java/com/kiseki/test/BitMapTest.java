
package com.kiseki.test;


import org.junit.Test;
import org.redisson.api.RBitSet;

import java.util.Random;

public class BitMapTest extends BaseTest{
    @Test
    public void test(){
        this.flushdb();
        RBitSet bitmapTest2020 = redissonClient.getBitSet("bitmapTest2020");
        int count = 0;
        for (int i = 0; i < 356; i++) {
            boolean flag = new Random().nextBoolean();
            if(flag){
                count++;
            }
            bitmapTest2020.set(i, flag);
        }
        long cardinality = bitmapTest2020.cardinality();
        System.out.println(count);
        System.out.println(cardinality);
    }
}