FROM openjdk:17
RUN mkdir -p /account-manager-parent/
ADD ./* /account-manager-parent/
WORKDIR /account-manager-parent
ENV JAVA_TOOL_OPTIONS "-XX:MaxRAMPercentage=90.0"
ENTRYPOINT ["java", "-jar", "/account-manager-parent/main/target/main-1.0.0.jar"]

EXPOSE 8123