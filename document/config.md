docker run -p 7379:6379 --name redis-5mb -v $PWD/redis-config/redis-5mb.conf:/etc/redis/redis.conf redis /etc/redis/redis.conf --appendonly yes  
docker run -p 7379:6379 --name redis-bloom redislabs/rebloom
docker run -p 7379:6379 --name redis-normal redis --appendonly yes  
docker run -p 7380:6379 --name redis-normal-slave -v $PWD/redis-config/redis-normal-slave.conf:/etc/redis/redis.conf redis /etc/redis/redis.conf --appendonly yes

docker run  goodsmileduck/redis-cli:v5.0.3 redis-cli  --cluster-replicas 3 --cluster create 192.168.6.181:6369 192.168.6.181:6379 192.168.6.181:6389 192.168.6.181:6368 192.168.6.181:6378 192.168.6.181:6388

docker run -p 9000:6379 --name redis-cluster-1 redis --appendonly yes  
docker run -p 9001:6379 --name redis-cluster-2 redis --appendonly yes  
docker run -p 9002:6379 --name redis-cluster-3 redis --appendonly yes  
docker run -p 9100:6379 --name redis-cluster-4 redis --appendonly yes  
docker run -p 9101:6379 --name redis-cluster-5 redis --appendonly yes  
docker run -p 9102:6379 --name redis-cluster-6 redis --appendonly yes  


docker run  goodsmileduck/redis-cli redis-cli  --cluster-replicas 1 --cluster create 127.0.0.1:9000 127.0.0.1:9001 127.0.0.1:9002 127.0.0.1:9100 127.0.0.1:9101 127.0.0.1:9102

sh redis-cluster.sh 
docker-compose -f docker-redis-cluster.yml up -d
docker exec -it redis7379 redis-cli -p 7379 --cluster create 10.112.101.43:7379 10.112.101.43:7380 10.112.101.43:7381 10.112.101.43:7382 10.112.101.43:7383 10.112.101.43:7384 --cluster-replicas 1
docker exec -it redis7379 redis-cli --cluster create 10.112.101.43:7379 10.112.101.43:7380 10.112.101.43:7381 10.112.101.43:7382 10.112.101.43:7383 10.112.101.43:7384 --cluster-replicas 1



FROM ruby:2.5-slim
MAINTAINER dongsilin<dslzc@foxmail.com>
RUN gem install redis
RUN mkdir /redis
WORKDIR /redis
ADD ./redis-trib.rb /redis/redis-trib.rb


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