# SpringCRUD

A RESTful CRUD API for client account management, built with **Spring Boot 2.7** and **Java 11**.

This project demonstrates a clean, layered backend architecture (Controller → Service → Repository), JPA-based persistence with auto-managed audit timestamps, DTO-driven API contracts, database version control via Liquibase, and interactive API documentation via OpenAPI / Swagger.

## Features

- Full CRUD operations for client records (`create`, `read`, `list`, `update`, `delete`)
- Layered architecture with clear separation of concerns
- DTO pattern: distinct request contracts for creation and partial update
- Bean Validation on incoming requests (`@NotBlank`, `@Size`)
- Automatic audit fields: `createDttm` and `modifyDttm`
- Enum-based status field with default (`ACTIVE` / `INACTIVE`)
- Centralized error handling via `ResponseStatusException` returning proper HTTP status codes (e.g. `404 Not Found`)
- Transactional write operations (`@Transactional`)
- Database schema version control with **Liquibase**
- Interactive API documentation with **Swagger UI** (springdoc-openapi)
- Reduced boilerplate via **Lombok**

## Tech Stack

- **Language:** Java 11
- **Framework:** Spring Boot 2.7.18
- **Web:** Spring Web MVC
- **Persistence:** Spring Data JPA, Hibernate, PostgreSQL
- **Schema migrations:** Liquibase
- **API docs:** springdoc-openapi (Swagger UI)
- **Validation:** Jakarta Bean Validation
- **Boilerplate reduction:** Lombok
- **Build:** Maven (via Maven Wrapper)

## Prerequisites

- JDK 11 or higher
- PostgreSQL 12+ running locally
## Roadmap

- [ ] Add unit tests (service layer with Mockito) and integration tests (MockMvc)
- [ ] Dockerize with `docker-compose` (app + PostgreSQL)
- [ ] Add global exception handler (`@ControllerAdvice`) for consistent error payloads
- [ ] Add pagination and filtering to `GET /api/clients`

## Author

**Daniil Frolov** — [github.com/reDan22](https://github.com/reDan22)
