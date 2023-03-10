FROM openjdk:11-jdk
RUN apt-get update && apt-get -y install sudo
ARG JAR_FILE="build/libs/fridgy-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} fridgy-api.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/fridgy-api.jar"]