FROM ubuntu:latest
WORKDIR /app

COPY pom.xml ./

WORKDIR /app/build
EXPOSE 8091
ENTRYPOINT ["top", "-b"]