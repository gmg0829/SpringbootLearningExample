FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD /target/dockercompose-springboot-mysql-nginx-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]