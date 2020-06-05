rm -rf redis-cluster
for port in `seq 7001 7006`; do \
    mkdir -p ./redis-cluster/${port}/conf \
    && PORT=${port} envsubst < ./redis-cluster.tmpl > ./redis-cluster/${port}/conf/redis.conf \
    && mkdir -p ./redis-cluster/${port}/data; \
    done


docker-compose -f docker-redis-cluster.yml up -d

docker exec -it redis7001 redis-cli -p 7001 --cluster create 10.112.101.43:7001 10.112.101.43:7002 10.112.101.43:7003 10.112.101.43:7004 10.112.101.43:7005 10.112.101.43:7006 --cluster-replicas 1