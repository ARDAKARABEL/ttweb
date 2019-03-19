FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
ADD /target/*.war /app.war
RUN sh -c 'touch /app.war'
EXPOSE 80
ENTRYPOINT ["java","-server","-Dfile.encoding=utf-8","-Duser.language=en","-Duser.country=US","-Xmx1G","-XX:+UseCompressedOops","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]