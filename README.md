# react-nhl-application
NHL application utilizing Spring Boot and React

### Dependencies
The following dependencies were added through the Spring Initializr.
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

### Installation and Startup
Clone the repository
```bash
git clone http://
```
Navigate to the project directory/
```bash
cd react-nhl-application
```
Start the project
```bash
mvn spring-boot run
```

### Implementation Details
- [Server-Side Development Log](documentation/SPRING-BOOT-SERVER-SIDE-DEV-LOG.md)
- [Client-Side Development Log](documentation/REACT-CLIENT-SIDE-DEV-LOG.md)