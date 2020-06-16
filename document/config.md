docker run -p 7379:6379 --name redis-5mb -v $PWD/redis-config/redis-5mb.conf:/etc/redis/redis.conf redis /etc/redis/redis.conf --appendonly yes  
docker run -p 7379:6379 --name redis-bloom redislabs/rebloom
docker run -p 7379:6379 --name redis-normal redis --appendonly yes  
docker run -p 7380:6379 --name redis-normal-slave -v $PWD/redis-config/redis-normal-slave.conf:/etc/redis/redis.conf redis /etc/redis/redis.conf --appendonly yes


sh redis-cluster.sh 
docker-compose -f docker-redis-cluster.yml up -d
docker exec -it redis7379 redis-cli -p 7379 --cluster create 10.112.101.43:7379 10.112.101.43:7380 10.112.101.43:7381 10.112.101.43:7382 10.112.101.43:7383 10.112.101.43:7384 --cluster-replicas 1
docker exec -it redis7379 redis-cli --cluster create 10.112.101.43:7379 10.112.101.43:7380 10.112.101.43:7381 10.112.101.43:7382 10.112.101.43:7383 10.112.101.43:7384 --cluster-replicas 1

--appendonly yes  
config set maxmemory-policy allkeys-lru
config set maxmemory-samples 5

volatile-lru  
volatile-lfu  
volatile-random  
volatile-ttl  
allkeys-lru  
allkeys-lfu  
allkeys-random  
noeviction


https://zhuanlan.zhihu.com/p/37055648
https://zhuanlan.zhihu.com/p/91047500
https://www.jianshu.com/p/2104d11ee0a2 详解布隆过滤器的原理、使用场景和注意事项
https://segmentfault.com/a/1190000020031841?utm_source=tag-newest Redis 6 新功能提前看！
https://zhuanlan.zhihu.com/p/95462736?utm_source=wechat_timeline 挑战Redis单实例内存最大极限，“遭遇”NUMA陷阱！ 
http://www.web-lovers.com/redis-source-ae.html 渐进式解析 Redis 源码 - 事件 ae
https://www.cnblogs.com/wangcuican/p/12882930.html Redis入门到精通（十二）——持久化AOF概念、AOF写数据的三种策略（always/everysec/no）、AOF重写方式（手动重写、自动重写）、AOF重写流程、RDB与AOF的选择、Redis持久化总结
https://zhuanlan.zhihu.com/p/143811218 【95期】面试官：你遇到 Redis 线上连接超时一般如何处理？
https://www.cnblogs.com/zhangrui153169/p/12835681.html Docker实战之Redis-Cluster集群
https://zhuanlan.zhihu.com/p/144805500 
https://juejin.im/post/5d07ac98e51d4577583ddccc
