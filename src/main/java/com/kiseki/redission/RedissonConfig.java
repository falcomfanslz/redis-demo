package com.kiseki.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

//    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s",redisProperties.getHost()+"",redisProperties.getPort()+"");
        config.useSingleServer().setAddress(redisUrl).setPassword(redisProperties.getPassword());
        config.useSingleServer().setDatabase(0);
        return Redisson.create(config);
    }
//    @Bean
    public RedissonClient redissonClientCluster(){
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        redisProperties.getCluster().getNodes().forEach(clusterServersConfig::addNodeAddress);
        redisProperties.getCluster().setMaxRedirects(3);
        return Redisson.create(config);
    }
    @Bean
    public RedissonClient redissonClientSentinel(){
        Config config = new Config();
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        redisProperties.getSentinel().getNodes().forEach(sentinelServersConfig::addSentinelAddress);
        sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster());
        return Redisson.create(config);
    }
}