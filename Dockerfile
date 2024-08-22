FROM bellsoft/liberica-openjdk-alpine-musl:17
ARG JAR_FILE=target/fareast-ago-adapter-1.0.0-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]