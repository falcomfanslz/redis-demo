docker run -p 7379:6379 --name redis-5mb -v $PWD/redis-config/redis-5mb.conf:/etc/redis/redis.conf redis /etc/redis/redis.conf --appendonly yes  
docker run -p 7379:6379 --name redis-bloom redislabs/rebloom

config set maxmemory-policy allkeys-lru

volatile-lru  
volatile-lfu  
volatile-random  
volatile-ttl  
allkeys-lru  
allkeys-lfu  
allkeys-random  
noeviction
