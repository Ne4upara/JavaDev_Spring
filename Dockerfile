FROM postgres
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin
EXPOSE 5432:5432
ENV POSTGRES_DB java

#docker build -t pg/javadespring:v1 .
#docker run --name pg_javadespring -d -p 5432:5432 pg/javadespring:v1