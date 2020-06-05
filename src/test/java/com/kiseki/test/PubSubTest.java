package com.kiseki.test;

import org.junit.Test;
import org.redisson.api.RTopic;

public class PubSubTest extends BaseTest{
    @Test
    public void test() throws Exception{
        this.buildSub("sub1");
        this.buildSub("sub2");
        this.buildSub("sub3");

        while (true){
            RTopic testTopic = redissonClient.getTopic("testTopic");
            String message = "hello" + System.currentTimeMillis();
            System.out.println("send:" + message);
            testTopic.publish(message);
            Thread.sleep(1000);
        }
    }
    private void buildSub(String subName){
        RTopic testTopic = redissonClient.getTopic("testTopic");
        testTopic.addListener(String.class, (channel, message) -> System.out.println("subName:" + subName + ", get message:" + message));
    }
}