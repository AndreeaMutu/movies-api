FROM openjdk:11
EXPOSE 8080
ADD ./target/movies-api-0.0.1-SNAPSHOT.jar /usr/src/app.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "app.jar"]