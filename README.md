# 📚 Student Management System

A full-stack Java web application designed to manage student records, courses, and profiles. This project was built to demonstrate enterprise-level development practices, including layered architecture, database integration, unit testing, and containerization for easy deployment.

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot 3, Spring MVC, Spring Data JPA
- **Database:** MySQL, Hibernate
- **Frontend:** HTML, CSS (Bootstrap 5), Thymeleaf
- **Testing:** JUnit 5, Mockito
- **DevOps:** Docker, Docker Compose
- **Build Tool:** Maven

## ✨ Features
- **Complete CRUD Operations:** Create, Read, and Delete student records.
- **Clean Architecture:** Strict separation of concerns using Controller, Service, and Repository layers.
- **Responsive UI:** A clean and modern interface built with Bootstrap.
- **Robust Testing:** Unit tests for the Service layer using JUnit and Mockito to ensure business logic is reliable.
- **Containerized Deployment:** The application and its MySQL database are fully containerized, allowing the entire stack to be launched with a single command.

## 🏗️ Architecture
The project follows a standard MVC (Model-View-Controller) pattern:
- **Controller:** Handles HTTP requests and routes, returning Thymeleaf views.
- **Service:** Contains the core business logic and acts as an interface between the controller and repository.
- **Repository:** Uses Spring Data JPA to interact with the MySQL database.
- **Entity:** Represents the `Student` table in the database.

## 🚀 How to Run Locally

### Prerequisites
- **Docker Desktop** installed and running on your machine.
- (Optional) Java 17 and Maven if you wish to run the application without Docker.

### Steps (Recommended: Using Docker)
1.  Clone the repository:
    ```bash
    git clone https://github.com/Asad6190/Student-Management-System.git
