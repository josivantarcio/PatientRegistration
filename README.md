# Patient Registration System

A RESTful API for managing patient and doctor registrations built with Spring Boot and JPA/Hibernate.

## About The Project

This is an educational project I created to teach Spring Boot fundamentals to my students. It provides a complete backend solution for managing medical records, allowing registration and management of doctors and their patients. 

The application serves as a practical example of:
- Building RESTful APIs with Spring Boot
- Implementing JPA/Hibernate relationships
- Using Lombok to write cleaner code
- Applying best practices in project structure

The system implements a one-to-many relationship where one doctor can have multiple patients, making it an excellent real-world scenario for learning backend development.

## Features

- Patient CRUD operations (Create, Read, Update, Delete)
- Doctor CRUD operations
- Doctor-Patient relationship management
- RESTful API endpoints
- Data persistence with JPA/Hibernate
- Input validation
- Clean code with Lombok annotations

## Built With

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Maven**
- **MySQL/PostgreSQL** (or your preferred database)

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6+
- MySQL/PostgreSQL database
- Your favorite IDE (IntelliJ IDEA recommended)

### Installation

1. Clone the repository
   ```bash
   git clone https://github.com/josivantarcio/PatientRegistration.git
   cd PatientRegistration
   ```

2. Configure your database in `application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/patient_registration
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Install dependencies
   ```bash
   mvn clean install
   ```

4. Run the application
   ```bash
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/jtarcio/cadastro/
│   │       ├── pessoas/
│   │       │   ├── medicos/
│   │       │   │   ├── entities/
│   │       │   │   │   └── DoctorEntity.java
│   │       │   │   ├── repositories/
│   │       │   │   ├── services/
│   │       │   │   └── controllers/
│   │       │   └── pacientes/
│   │       │       ├── entities/
│   │       │       │   └── PatientEntity.java
│   │       │       ├── repositories/
│   │       │       ├── services/
│   │       │       └── controllers/
│   └── resources/
│       └── application.properties
```

## API Endpoints

### Doctors

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/doctors` | Get all doctors |
| GET | `/api/doctors/{id}` | Get doctor by ID |
| POST | `/api/doctors` | Create new doctor |
| PUT | `/api/doctors/{id}` | Update doctor |
| DELETE | `/api/doctors/{id}` | Delete doctor |

### Patients

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Create new patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |

## Data Models

### Doctor Entity

```java
@Entity
@Table(name = "tb_doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String telefone;
    private String crm;
    
    @OneToMany(mappedBy = "doctor")
    private List<PatientEntity> patients;
}
```

### Patient Entity

```java
@Entity
@Table(name = "tb_pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Integer age;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;
}
```

## Technologies Deep Dive

### Lombok Integration

This project uses Lombok to reduce boilerplate code. The following annotations are used:

- `@Getter` / `@Setter` - Generate getters and setters
- `@NoArgsConstructor` - Generate no-args constructor
- `@AllArgsConstructor` - Generate constructor with all fields
- `@ToString` - Generate toString() method
- `@EqualsAndHashCode` - Generate equals() and hashCode() methods

**Maven Dependency:**
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.42</version>
    <scope>provided</scope>
</dependency>
```

### JPA Relationships

The project implements a **One-to-Many** / **Many-to-One** bidirectional relationship:

- One Doctor can have multiple Patients (`@OneToMany`)
- Multiple Patients belong to one Doctor (`@ManyToOne`)
- The `mappedBy` attribute establishes the owner side of the relationship

## Database Schema

```sql
CREATE TABLE tb_doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    crm VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE tb_pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    email VARCHAR(255) NOT NULL,
    doctor_id BIGINT,
    FOREIGN KEY (doctor_id) REFERENCES tb_doctors(id)
);
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Josivan Tarcio - [@josivantarcio](https://github.com/josivantarcio)

Project Link: [https://github.com/josivantarcio/PatientRegistration](https://github.com/josivantarcio/PatientRegistration)

## Acknowledgments

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Project Lombok](https://projectlombok.org/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate ORM](https://hibernate.org/)

---

**Tags:** `#SpringBoot` `#Java` `#REST-API` `#JPA` `#Hibernate` `#Lombok` `#Maven` `#Backend` `#CRUD` `#PatientManagement` `#MedicalSystem` `#DatabaseRelationships`
