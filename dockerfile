FROM openjdk:8-jdk
COPY target/prevalentware-0.0.1-SNAPSHOT.jar prueba-prevalentware.jar
ENTRYPOINT ["java", "-jar", "prueba-prevalentware.jar"]