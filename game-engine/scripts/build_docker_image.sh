#!/bin/sh

docker stop game-engine
docker rm game-engine
docker rmi game-engine

./gradlew clean build

docker build -t game-engine .
