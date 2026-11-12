<div align="center">

# 🏃 Runners Club

### A Spring MVC web application for managing running clubs and their events

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-6DB33F?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-wrapper-C71A36?logo=apachemaven&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/views-Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)
![Database](https://img.shields.io/badge/database-MySQL-4479A1?logo=mysql&logoColor=white)

[Features](#-features) · [Technology](#-technology-stack) · [Getting started](#-getting-started) · [Application routes](#-application-routes) · [Project structure](#-project-structure)

</div>

---

## 📖 About

**Runners Club** is a server-rendered web application built with Spring MVC. It provides pages and workflows for browsing and managing running clubs and the events associated with them. Users can register and sign in, browse club and event listings, view details, and use forms to create, edit, and delete records.

The application uses Spring Boot, Thymeleaf templates, Spring Data JPA, and MySQL. The Java code is organized into web controllers, services, repositories, entities, and DTOs; HTML views and static assets are stored under the Spring Boot resources directory.

> **Project status:** This README describes the source currently in the repository. Configure a local MySQL database before running the application. The repository does not include production deployment configuration or a database seed script.

## ✨ Features

- **Club directory** — list, search, view, create, update, and delete running clubs.
- **Event management** — list events, view event details, and create, update, or delete events associated with clubs.
- **Account pages** — registration and login pages, with registration input validation and duplicate username/email checks.
- **Server-rendered UI** — Thymeleaf templates with a shared layout, CSS styling, and JavaScript assets.
- **Persistence** — Spring Data JPA repositories backed by MySQL.
- **Validation and security dependencies** — Spring Boot validation and Spring Security are included in the application.

## 🧰 Technology stack

| Area | Technologies |
| --- | --- |
| Language | Java 17 |
| Framework | Spring Boot 3.3.4, Spring MVC |
| Views | Thymeleaf, Thymeleaf Layout Dialect |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL, MySQL Connector/J 8.0.33 |
| Validation and security | Spring Boot Validation, Spring Security |
| Build and tests | Maven Wrapper, Spring Boot Starter Test |
| UI assets | HTML, CSS, JavaScript |

## 🚀 Getting started

### Prerequisites

Install or have access to:

- **JDK 17** (and `JAVA_HOME` configured)
- **MySQL 8.x** or a compatible MySQL server
- A terminal; Maven is not required because the repository includes the Maven Wrapper

### 1. Get the code

```bash
git clone https://github.com/Rawkesh2k/Runners_Club_With_Spring_MVC.git
cd Runners_Club_With_Spring_MVC
```

### 2. Create a MySQL database

Create the database named `mvc_spring`, or choose another name and update the datasource URL accordingly:

```sql
CREATE DATABASE mvc_spring CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configure the database and credentials

The default local datasource settings are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mvc_spring
spring.datasource.username=root
spring.datasource.password=root
```

Change the username and password to match your local MySQL account. **Do not use the checked-in sample credentials outside a local development environment.** You can override Spring Boot properties through environment variables, for example:

```bash
export SPRING_DATASOURCE_URL='jdbc:mysql://localhost:3306/mvc_spring'
export SPRING_DATASOURCE_USERNAME='your_mysql_user'
export SPRING_DATASOURCE_PASSWORD='your_mysql_password'
```

In PowerShell, use `$env:SPRING_DATASOURCE_URL`, `$env:SPRING_DATASOURCE_USERNAME`, and `$env:SPRING_DATASOURCE_PASSWORD` to set the corresponding environment variables.

The current configuration uses `spring.jpa.hibernate.ddl-auto=update`, which lets Hibernate update the schema during development. For production, use a managed schema migration process and review database settings before deployment. SQL statement logging is also enabled by default (`spring.jpa.show-sql=true`).

### 4. Run the application

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

On Windows Command Prompt:

```bat
mvnw.cmd spring-boot:run
```

The app starts at **http://localhost:8080**. Start at `/clubs` to browse the club directory, or visit `/register` and `/login` for the account pages.

### 5. Build and test

```bash
./mvnw test
./mvnw package
```

On Windows, replace `./mvnw` with `mvnw.cmd`. The packaged application JAR is written to `target/` and can be launched with:

```bash
java -jar target/mvc-0.0.1-SNAPSHOT.jar
```

## 🧭 Application routes

The following routes are mapped by the MVC controllers. Routes that include an ID use the record's database identifier.

| Method | Path | Purpose |
| --- | --- | --- |
| `GET` | `/clubs` | Show the club directory |
| `GET` | `/clubs/search?query=...` | Search clubs |
| `GET` | `/clubs/new` | Show the new-club form |
| `POST` | `/clubs/new` | Save a club |
| `GET` | `/clubs/{clubId}` | Show club details |
| `GET` | `/clubs/{clubId}/edit` | Show the edit-club form |
| `POST` | `/clubs/{clubId}/edit` | Update a club |
| `GET` | `/clubs/{clubId}/delete` | Delete a club |
| `GET` | `/events` | Show the event directory |
| `GET` | `/events/{eventId}` | Show event details |
| `GET` | `/events/{clubId}/new` | Show the new-event form for a club |
| `POST` | `/events/{clubId}` | Save an event for a club |
| `GET` | `/events/{eventId}/edit` | Show the edit-event form |
| `POST` | `/events/{eventId}/edit` | Update an event |
| `GET` | `/events/{eventId}/delete` | Delete an event |
| `GET` | `/register` | Show the registration form |
| `POST` | `/register/save` | Validate and save a registration |
| `GET` | `/login` | Show the login page |

## 🗂️ Project structure

```text
src/
├── main/
│   ├── java/com/springMVC/mvc/
│   │   ├── controller/       # MVC controllers for clubs, events, and accounts
│   │   ├── dto/              # Form and view data transfer objects
│   │   ├── mapper/           # Entity/DTO mapping
│   │   ├── models/           # JPA entities and role model
│   │   ├── repository/       # Spring Data repositories
│   │   ├── service/          # Service interfaces and implementations
│   │   └── MvcApplication.java
│   └── resources/
│       ├── static/           # CSS, JavaScript, and other static assets
│       ├── templates/        # Thymeleaf pages and shared layout
│       └── application.properties
└── test/                     # Application tests
```

## 🔐 Security and configuration notes

- The checked-in `application.properties` contains local development defaults, including database credentials and a Spring Security username/password. Replace these values for your own environment, and do not commit real credentials.
- Avoid using default or shared credentials in a deployed application. Review authentication, authorization, password handling, CSRF, and session settings before exposing the app publicly.
- The current routes include delete operations as `GET` requests. For a production deployment, use state-changing `POST`/`DELETE` requests with appropriate CSRF protection.
- The repository's default JPA schema mode is `update`; use deliberate migrations and backups when managing a production database.

## 🧪 Tests

Run the project test suite with:

```bash
./mvnw test
```

Tests are located under `src/test/java`. Add or extend tests when changing controller, service, or persistence behavior.

## 🤝 Contributing

1. Fork the repository and create a feature branch.
2. Make a focused change and add or update tests where appropriate.
3. Run `./mvnw test` and verify the application locally.
4. Open a pull request describing the change and any configuration impact.

## 📄 License

No license is currently specified in the repository. Unless a license is added, standard copyright restrictions apply; please contact the repository owner before redistributing this project.

---

<div align="center">

Built for runners who like to keep their clubs and events moving. 🏁

</div>
