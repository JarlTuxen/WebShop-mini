FROM openjdk:latest
COPY target/webshop-0.0.1-SNAPSHOT.jar /usr/src/webshop-0.0.1-SNAPSHOT.jar
CMD java -jar /usr/src/webshop-0.0.1-SNAPSHOT.jar
