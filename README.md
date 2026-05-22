# Bookstore Spring Boot App

Simple Spring Boot CRUD example for a bookstore using Java 21 and H2 in-memory database.

Run:

```
mvn spring-boot:run
```

API endpoints:

- `GET /api/books` — list books
- `GET /api/books/{id}` — get book
- `POST /api/books` — create book (JSON body)
- `PUT /api/books/{id}` — update book
- `DELETE /api/books/{id}` — delete book

H2 console: `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:bookdb`)
# workPrep