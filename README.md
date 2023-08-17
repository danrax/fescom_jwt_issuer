#FESCOM backend

##Requirements
- java (jdk 17)
- gradle (7.5.1)
- Connection to a mysqlDB (8.0.30)
- Docker (version 20.10.17)


##Mofidications to project

Go to the src/main/resources/application.yml file and replace the following with your information:
- tag: <b>ip</b> with the ip address of the database.
- tag: <b>your-password</b> with the database password.

## Install dependencies

```bash
./gradlew clean build --refresh-dependencies
```

## Run project
```bash
java -jar build/libs/fescom.jar
```

##Docker

This project contains a DockerFile to create a Docker image with the project.

To build the Docker image, locate on the root folder of your project and execute the following command:

```bash
docker build -t fescom-backend-app .
```

Then, to run the docker image, execute the followin docker command:

```bash
docker run —name fescom—backend -p  8080:8080 fescom-backend-app
```