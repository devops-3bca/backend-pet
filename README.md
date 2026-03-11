# Pet Adoption System - Spring Boot Backend

## Build with Maven
```bash
mvn clean install
mvn spring-boot:run
```

## Build with Docker
```bash
docker build -t pet-adoption-backend:latest -f Dockerfile .
docker run -p 8080:8080 pet-adoption-backend:latest
```

## H2 Database Console
Access at: http://localhost:8081 or http://localhost:8082

## API Endpoints

### Add Pet
```bash
POST /api/pets
Content-Type: application/json

{
  "name": "Buddy",
  "breed": "Golden Retriever",
  "age": "2 years",
  "color": "Golden",
  "imageUrl": "https://...",
  "description": "Friendly and energetic dog"
}
```

### Get All Pets
```bash
GET /api/pets
```

### Get Available Pets
```bash
GET /api/pets/available
```

### Get Adopted Pets
```bash
GET /api/pets/adopted
```

### Get Pet by ID
```bash
GET /api/pets/{id}
```

### Adopt Pet
```bash
PUT /api/pets/{id}/adopt
```

### Delete Pet
```bash
DELETE /api/pets/{id}
```

### Update Pet
```bash
PUT /api/pets/{id}
Content-Type: application/json

{
  "name": "Buddy Updated",
  "breed": "Golden Retriever",
  "age": "3 years",
  "color": "Golden",
  "imageUrl": "https://...",
  "description": "Updated description"
}
```

Backend updates and improvements

# 🐾 Pet Adoption Backend (Docker + SonarQube)

This is the backend service for the **Pet Adoption** application, built with **Spring Boot**, **Java 17**, **Spring Web**, **Spring Data JPA**, and **PostgreSQL**.  
It is containerized with **Docker** and integrates with **SonarQube** (via Docker image) for static code analysis.

---

## 🚀 Features
- RESTful API for managing pets
- CRUD operations (Create, Read, Update, Delete)
- Mark pets as adopted
- Filter pets by availability/adopted status
- CORS enabled for frontend integration
- Dockerized for deployment
- SonarQube analysis via Docker image

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL (production) / H2 (local dev)
- Maven
- Docker
- SonarQube

---
## Render Running Status
   <img width="1915" height="722" alt="render" src="https://github.com/user-attachments/assets/e97293bb-cf8b-41b3-bc23-79e3e7187a46" />

## Sonar Analysis for Backend 
<img width="1918" height="482" alt="sonar" src="https://github.com/user-attachments/assets/a920543d-f555-4447-9796-5dcb0fe614b5" />
