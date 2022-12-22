#!/bin/sh
MAIN=apigateway
ARTIFACT=${MAIN}lib
VER=1.0
LIBS=./build/libs
JAR=$LIBS/$ARTIFACT-$VER.jar
GROUP=com.churchclerk
MVN=../../../apache-maven-3.6.1/bin/mvn

case $1 in
  build)
    ./gradlew clean build dockerInit
    ;;

  docker)
    cd build/docker
    docker build -t dongpak/${MAIN}:latest -f jdk8.dockerfile .
    ;;

  run)
    docker service create --name ${MAIN} --network $2 --secret source=$3,target=churchclerk --publish 18080:8080 dongpak/${MAIN}:latest
    ;;

  debug)
    docker service create --name ${MAIN} --network $2 --secret source=$3,target=churchclerk --publish 18080:8080 --env APP_ARG=--debug dongpak/${MAIN}:latest
    ;;

  *)
    echo "util.sh build - runs the gradle build command"
    echo "util.sh docker - builds the docker image"
    echo "util.sh run <network> <secret> - starts the service"
    echo "util.sh debug <network> <secret> - starts the service in debug"
    ;;
esac

<plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>2.7.1</version>
                <configuration>
                    <to>
                        <image>container-registry.hudsonmx.net/hudsonmx/${project.artifactId}:${project.version}${version.type}</image>
                        <auth>
                            <username>${nexus.username}</username>
                            <password>${nexus.password}</password>
                        </auth>
                    </to>
                </configuration>
            </plugin>