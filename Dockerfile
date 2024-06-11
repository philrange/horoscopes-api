#
# Build stage
#
FROM maven:3.8.2-eclipse-temurin-17
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Run stage
#
FROM maven:3.8.2-eclipse-temurin-17
COPY --from=build /home/app/target/horoscopes-api-0.0.1-SNAPSHOT.war /usr/local/lib/horoscopes-api-0.0.1-SNAPSHOT.war
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/horoscopes-api-0.0.1-SNAPSHOT.war"]

