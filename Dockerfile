FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /taco-cloud

COPY out/artifacts/taco_cloud_jar/taco-cloud.jar .

ENTRYPOINT ["java", "-jar", "taco-cloud.jar"]