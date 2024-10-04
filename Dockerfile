FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/Calc-1.0-SNAPSHOT.jar /app/Calc.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/Calc.jar"]
