#!/bin/sh

docker stop micronaut-vt
docker rm micronaut-vt
docker rmi micronaut-vt

./gradlew clean build

docker build -t micronaut-vt .
