FROM ubuntu:latest
LABEL authors="maria"

ENTRYPOINT ["top", "-b"]

COPY .mvn/ ./mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY scr ./scr

CMD ["./mvnw", "spring-boot:run"]