#!/bin/sh

docker stop micronaut-vt
docker rm micronaut-vt
docker run --rm --name micronaut-vt --memory="256m" -p 8080:8080 micronaut-vt
