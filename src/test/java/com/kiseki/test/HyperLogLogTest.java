
package com.kiseki.test;

import org.junit.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RHyperLogLog;

import java.text.DecimalFormat;


public class HyperLogLogTest extends BaseTest{
    @Test
    public void test(){
        this.flushdb();

        String format="0.00";
        DecimalFormat dec = new DecimalFormat(format);

        RHyperLogLog<Object> hyperLogLogTest = redissonClient.getHyperLogLog("hyperLogLogTest");
        for(int i = 1; i <= 10000; i++){
            hyperLogLogTest.add("userId" + i);
            if(i % 1000 == 0){
                System.out.println("当前准确计数为:" + i + ", hyperLogLog计数为:" + hyperLogLogTest.count() + ", 错误率:" + dec.format((double)(i-hyperLogLogTest.count())*100 / i) + "%");
            }
        }
    }
}