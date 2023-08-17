FROM gradle:7.5.1-jdk17
WORKDIR fescom
COPY . .
RUN gradle clean build --refresh-dependencies
RUN ls build/libs
ENTRYPOINT java -jar build/libs/fescom.jar
EXPOSE 8080