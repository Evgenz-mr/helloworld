FROM openjdk:8

COPY target/helloworld-1.1.jar /home/app.jar

WORKDIR /home

CMD ["java", "-jar", "/home/app.jar"]
