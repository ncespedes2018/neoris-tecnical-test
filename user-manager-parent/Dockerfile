FROM openjdk:17
RUN mkdir -p /account-manager-parent/
ADD ./* /user-manager-parent/
WORKDIR /user-manager-parent
ENV JAVA_TOOL_OPTIONS "-XX:MaxRAMPercentage=90.0"
ENTRYPOINT ["java", "-jar", "/user-manager-parent/main/target/main-1.0.0.jar"]

EXPOSE 8122
