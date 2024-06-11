FROM maven:3.8.2-eclipse-temurin-17
 
WORKDIR /app
 
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
CMD ["mvn", "spring-boot:run"]
