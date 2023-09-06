FROM openjdk:17
RUN mkdir -p /account-manager-parent/
ADD main/target/main-1.0.0.jar /account-manager-parent/main.jar
WORKDIR /account-manager-parent
ENV JAVA_TOOL_OPTIONS "-XX:MaxRAMPercentage=90.0"
ENTRYPOINT ["java", "-jar", "/account-manager-parent/main.jar"]
EXPOSE 8126