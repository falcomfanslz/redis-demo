rm -rf redis-sentinel
for port in `seq 7001 7003`; do \
    mkdir -p ./redis-sentinel/servers/${port}/conf \
    && PORT=${port} IP=${port: -1} envsubst < ./redis.tmpl > ./redis-sentinel/servers/${port}/conf/redis.conf; \
    done

mkdir redis-sentinel/config
cp ./sentinel.conf ./redis-sentinel/config/sentinel1.conf
cp ./sentinel.conf ./redis-sentinel/config/sentinel2.conf
cp ./sentinel.conf ./redis-sentinel/config/sentinel3.conf

docker-compose -f docker-compose.yml up -d
