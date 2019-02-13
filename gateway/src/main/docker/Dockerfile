FROM bys-cd.chinacloudapp.cn/library/openjdk:8-alpine

VOLUME /tmp
EXPOSE 8970

ADD common-gateway-new.jar app.jar

CMD exec java -Djava.security.egd=file:/dev/./urandom $PARAM -jar /app.jar
