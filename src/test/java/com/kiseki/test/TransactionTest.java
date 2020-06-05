package com.kiseki.test;


import org.junit.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RTransaction;
import org.redisson.api.TransactionOptions;

public class TransactionTest extends BaseTest{
    @Test
    public void test(){
        this.flushdb();
        redissonClient.getBucket("test").set("test");

        RTransaction transaction = redissonClient.createTransaction(TransactionOptions.defaults());
        RBucket<String> bucket = transaction.getBucket("test");
        String test = bucket.get();
        bucket.set(test + "1");
        String s = bucket.get();
        bucket.set(s + "2");
        transaction.commit();
    }
}