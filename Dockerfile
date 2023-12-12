FROM khipu/openjdk17-alpine
COPY ./target/goit-0.0.1-SNAPSHOT.jar ~/goit-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","~/goit-0.0.1-SNAPSHOT.jar"]

#docker build -t pg/javadespring:v1 .
#docker run --name pg_javadespring -d -p 5432:5432 pg/javadespring:v1

