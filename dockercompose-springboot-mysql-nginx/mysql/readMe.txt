docker build -t registry.cn-hangzhou.aliyuncs.com/gmg/docker-mysql:0.0.1 .
docker run -d -p 3306:3306 registry.cn-hangzhou.aliyuncs.com/gmg/docker-mysql:0.0.1

docker push registry.cn-hangzhou.aliyuncs.com/gmg/app:0.0.1