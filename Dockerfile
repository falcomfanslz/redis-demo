FROM java
VOLUME /tmp
ADD target/*.jar app.jar

#EXPOSE 9090
ENTRYPOINT [ "java", "-Djava.securityls.egd=file:/dev/./urandom", "-jar", "/app.jar" ]
