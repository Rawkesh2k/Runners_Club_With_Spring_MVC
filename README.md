<div align="center">

# 🏃 Runners Club

### Find your pace. Build your community. Run together.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring-MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Views-Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

[✨ Features](#-features) · [🧰 Tech stack](#-technology-stack) · [🚀 Setup](#-getting-started) · [🧭 Routes](#-application-routes) · [🗂️ Structure](#️-project-structure)

</div>

---

## 🌟 About

**Runners Club** is a server-rendered web application for discovering and managing running clubs and their events. It includes club and event workflows, registration and login pages, and a web UI rendered with Thymeleaf.

The application is built with Spring Boot and Spring MVC. Its Java code is organized into controllers, services, repositories, entities, DTOs, and mappers, with MySQL persistence through Spring Data JPA.

> **Project status:** This README reflects the code currently in the repository. Local MySQL configuration is required. The repository does not include production deployment configuration or a database seed script.

## ✨ Features

| 🏃 Clubs | 📅 Events | 👤 Accounts |
| --- | --- | --- |
| Browse, search, view, create, edit, and delete clubs | Browse, view, create, edit, and delete club events | Registration and login pages with validation and duplicate username/email checks |

- 🎨 Thymeleaf views with a shared layout, CSS, and JavaScript assets
- 💾 MySQL persistence using Spring Data JPA
- ✅ Form validation using Spring Boot Validation
- 🔐 Spring Security dependency included

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
| UI | HTML, CSS, JavaScript |

## 🚀 Getting started

### ✅ Prerequisites

- JDK 17 with `JAVA_HOME` configured
- MySQL 8.x or a compatible MySQL server
- A terminal (the repository includes Maven Wrapper scripts, so a separate Maven install is not required)

### 1. 📥 Clone the repository

```bash
git clone https://github.com/Rawkesh2k/Runners_Club_With_Spring_MVC.git
cd Runners_Club_With_Spring_MVC
```

### 2. 🗄️ Create a database

Create the default database, or choose another name and update the datasource URL accordingly:

```sql
CREATE DATABASE mvc_spring CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. ⚙️ Configure the datasource

The local datasource settings are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mvc_spring
spring.datasource.username=root
spring.datasource.password=root
```

Update the username and password for your MySQL installation. The checked-in values are development defaults—**do not use them outside a local environment**. You can instead provide environment variables, for example on macOS/Linux:

```bash
export SPRING_DATASOURCE_URL='jdbc:mysql://localhost:3306/mvc_spring'
export SPRING_DATASOURCE_USERNAME='your_mysql_user'
export SPRING_DATASOURCE_PASSWORD='your_mysql_password'
```

In PowerShell, use `$env:SPRING_DATASOURCE_URL`, `$env:SPRING_DATASOURCE_USERNAME`, and `$env:SPRING_DATASOURCE_PASSWORD`.

The project currently sets `spring.jpa.hibernate.ddl-auto=update` for development and enables SQL logging. For production, prefer managed schema migrations, review logging, and maintain appropriate backups.

### 4. ▶️ Run the application

macOS/Linux:

```bash
./mvnw spring-boot:run
```

Windows Command Prompt:

```bat
mvnw.cmd spring-boot:run
```

Open **http://localhost:8080/clubs** to browse the club directory. Account pages are available at `/register` and `/login`.

### 5. 🧪 Build and test

```bash
./mvnw test
./mvnw package
```

On Windows, use `mvnw.cmd` instead of `./mvnw`. The packaged JAR is written to `target/` and can be launched with:

```bash
java -jar target/mvc-0.0.1-SNAPSHOT.jar
```

## 🧭 Application routes

Routes with an ID use the record's database identifier.

| Method | Path | Purpose |
| --- | --- | --- |
| `GET` | `/clubs` | Browse clubs |
| `GET` | `/clubs/search?query=...` | Search clubs |
| `GET` | `/clubs/new` | Show the new-club form |
| `POST` | `/clubs/new` | Save a club |
| `GET` | `/clubs/{clubId}` | View club details |
| `GET` | `/clubs/{clubId}/edit` | Show the edit-club form |
| `POST` | `/clubs/{clubId}/edit` | Update a club |
| `GET` | `/clubs/{clubId}/delete` | Delete a club |
| `GET` | `/events` | Browse events |
| `GET` | `/events/{eventId}` | View event details |
| `GET` | `/events/{clubId}/new` | Show a new-event form for a club |
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
│   │   ├── controller/       # Club, event, and account MVC controllers
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

## 🔐 Security and deployment notes

- Replace the sample datasource and Spring Security credentials with secure, environment-specific values; never commit production secrets.
- Review authentication, authorization, password handling, CSRF, and session settings before exposing the app publicly.
- The current delete routes use `GET`. For production, use state-changing `POST`/`DELETE` operations with appropriate CSRF protection.
- Use deliberate database migrations and backups rather than relying on `ddl-auto=update` for production.

## 🤝 Contributing

1. Fork the repository and create a feature branch.
2. Make a focused change and add or update tests as appropriate.
3. Run `./mvnw test` and verify the app locally.
4. Open a pull request describing the change and any configuration impact.

## 📜 License

No license is currently specified in the repository. Unless a license is added, standard copyright restrictions apply; please contact the repository owner before redistributing this project.

---

<div align="center">

🏁 **Built for runners who like to keep their clubs and events moving.**

</div>
