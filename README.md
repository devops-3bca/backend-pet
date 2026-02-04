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

