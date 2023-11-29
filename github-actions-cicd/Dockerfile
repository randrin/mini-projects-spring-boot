FROM openjdk:17
EXPOSE 8080
ADD ./github-actions-cicd/target/springboot-github-cicd.jar springboot-github-cicd.jar
ENTRYPOINT ["java", "-jar", "/springboot-github-cicd.jar"]