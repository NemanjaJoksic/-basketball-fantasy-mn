FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.17

WORKDIR /app

COPY build/libs/game-engine-1.0.0-all-optimized.jar application.jar

ENTRYPOINT java -jar -XX:InitialRAMPercentage=75 -XX:MaxRAMPercentage=75 application.jar
