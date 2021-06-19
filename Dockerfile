FROM openjdk:11-slim-buster

ADD build/libs/videos-0.0.1-SNAPSHOT.jar /

EXPOSE 8080

ENTRYPOINT [ "java", "-XX:MinRAMPercentage=50", "-XX:MaxRAMPercentage=50", "-Djava.security.edg=file:/dev/./urandom", "-Dfile.encoding=UTF8", "-Duser.timezone=America/Sao_Paulo", "-Duser.language=pt", "-Duser.country=BR", "-jar", "/videos-0.0.1-SNAPSHOT.jar" ]