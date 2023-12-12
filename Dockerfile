FROM postgres
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB java

#docker build -t pg/javadespring:v1 .
#docker run --name pg_javadespring -d -p 5432:5432 pg/javadespring:v1
#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
#docker push pg/javadespring:v1
#echo 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 | docker login ghcr.io -u ваш_аккаунт_на_github --password-stdin