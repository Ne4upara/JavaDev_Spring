FROM postgres
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB java

WORKDIR /goit
COPY --from=build /app/out .

# Ваша точка входа (ENTRYPOINT) должна быть исправлена, без круглых скобок
ENTRYPOINT ["./goit-dotnet.dll"]

#docker build -t pg/javadespring:v1 .
#docker run --name pg_javadespring -d -p 5432:5432 pg/javadespring:v1

