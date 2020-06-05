for port in `seq 7001 7003`; do \
    mkdir -p ./redis/servers/${port}/conf \
    && PORT=${port} envsubst < ./redis/redis.tmpl > ./redis/servers/${port}/conf/redis.conf; \
    done

docker-compose -f redis/docker-redis.yml up -d

docker-compose -f sentinel/docker-redis-sentinel.yml up -d
