rm -rf redis-sentinel
for port in `seq 7001 7003`; do \
    mkdir -p ./redis-sentinel/servers/${port}/conf \
    && PORT=${port} IP=${port: -1} envsubst < ./redis.tmpl > ./redis-sentinel/servers/${port}/conf/redis.conf; \
    done

mkdir redis-sentinel/config
for port in `seq 26379 26381`; do \
    PORT=${port} envsubst < ./sentinel.tmpl > ./redis-sentinel/config/sentinel${port}.conf; \
    done

docker-compose -f docker-compose.yml up -d
