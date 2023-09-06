FROM openjdk:17
RUN mkdir -p /user-manager-parent/
ADD main/target/main-1.0.0.jar /user-manager-parent/main.jar
WORKDIR /user-manager-parent
ENV JAVA_TOOL_OPTIONS "-XX:MaxRAMPercentage=90.0"
ENTRYPOINT ["java", "-jar", "/user-manager-parent/main.jar"]
EXPOSE 8125
