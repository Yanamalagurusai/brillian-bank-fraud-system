# Auth Service

Spring Boot 3 authentication microservice using Java 17, Maven, MySQL 8, Spring Security, JWT, Spring Data JPA, and Lombok.

## Endpoints

- `POST /api/auth/register`
- `POST /api/auth/login`

## Register request

```json
{
  "name": "Customer User",
  "email": "customer@example.com",
  "password": "secret123",
  "role": "CUSTOMER"
}
```

Roles: `CUSTOMER`, `ADMIN`, `VENDOR`.

## Login request

```json
{
  "email": "customer@example.com",
  "password": "secret123"
}
```

Update `src/main/resources/application.properties` with your MySQL username, password, database URL, and a strong `jwt.secret` before running in production.
