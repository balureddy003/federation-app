# FederationApp

This project provides a simplified example of an OpenID Federation 1.0 implementation using Spring Boot.

## Running in VS Code

1. Install the **Java Extension Pack** and **Spring Boot Extension Pack** in VS Code.
2. Make sure JDK 17 and Maven are available on your PATH.
3. Open the project folder in VS Code (`File` -> `Open Folder`).
4. Open the integrated terminal (`Terminal` -> `New Terminal`) and run:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:8080`.
5. To build a runnable jar use `mvn clean package` and execute:
   ```bash
   java -jar target/FederationApp-0.0.1-SNAPSHOT.jar
   ```
6. Browse the API at `http://localhost:8080/swagger-ui.html`.
