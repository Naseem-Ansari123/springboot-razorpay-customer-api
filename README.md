# 💳 Spring Boot Razorpay Customer API

> A production-style RESTful Customer Management API built with **Java, Spring Boot, Spring Data JPA, MySQL and Razorpay integration**.

[![Java](https://img.shields.io/badge/Java-24-orange?style=for-the-badge\&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen?style=for-the-badge\&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge\&logo=mysql)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge\&logo=apachemaven)](https://maven.apache.org/)
[![REST API](https://img.shields.io/badge/API-RESTful-6f42c1?style=for-the-badge)](#api-endpoints)

---

## 🚀 About The Project

**Spring Boot Razorpay Customer API** is a backend REST API designed to manage customer information and provide a foundation for integrating customer/payment workflows with **Razorpay**.

The project demonstrates how to build a structured Java backend using the **Spring Boot ecosystem**, including:

* RESTful API development
* Spring MVC
* Spring Data JPA
* MySQL database integration
* DTO-based request/response handling
* Customer CRUD operations
* UUID-based customer identification
* Pagination-style customer fetching
* Maven dependency management
* Lombok
* Razorpay-oriented backend architecture

The project follows a layered backend architecture to keep business logic, API handling and data access separated.

---

## ✨ Key Features

### 👤 Customer Management

* Create a new customer
* Retrieve a customer using UUID
* Update existing customer information
* Fetch multiple customers
* Configurable `count` and `skip` parameters
* DTO-based API communication

### 🧩 Backend Architecture

The application follows a clean layered approach:

```text
                ┌──────────────────────┐
                │       Client         │
                │ Postman / Frontend   │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │     Controller       │
                │   REST API Layer     │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │       Service        │
                │   Business Logic     │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │     Repository       │
                │    JPA Data Layer    │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │        MySQL         │
                │       Database       │
                └──────────────────────┘
```

---

## 🛠️ Tech Stack

| Technology           | Purpose                       |
| -------------------- | ----------------------------- |
| ☕ Java 24            | Programming Language          |
| 🌱 Spring Boot 4.0.6 | Backend Framework             |
| 🌐 Spring Web MVC    | REST API Development          |
| 🗄️ Spring Data JPA  | Database Access               |
| 🐬 MySQL             | Relational Database           |
| 📦 Maven             | Dependency & Build Management |
| 🔧 Lombok            | Boilerplate Reduction         |
| 🔑 UUID              | Customer Identification       |
| 🧪 Postman           | API Testing                   |
| 💳 Razorpay          | Payment/Customer Integration  |

---

## 📁 Project Structure

```text
springboot-razorpay-customer-api
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── customers/
│   │   │           └── demo/
│   │   │               ├── Controller/
│   │   │               ├── DTO/
│   │   │               ├── Entity/
│   │   │               ├── Repository/
│   │   │               └── Service/
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

# 🔗 API Endpoints

Base URL:

```text
http://localhost:8080/v1
```

---

## 1️⃣ Create Customer

### `POST /v1/createCustomer`

Creates a new customer.

### Request Body

```json
{
  "name": "Naseem Book Store",
  "contact": "9876543210",
  "email": "naseem@example.com",
  "gstin": "27ABCDE1234F1Z5",
  "fail_existing": "0",
  "notes": {}
}
```

### Response

```json
{
  "id": "customer-uuid",
  "name": "Naseem Book Store",
  "contact": "9876543210",
  "email": "naseem@example.com"
}
```

---

## 2️⃣ Get Customer

### `GET /v1/customers?id={UUID}`

Retrieves a specific customer using their UUID.

Example:

```text
GET http://localhost:8080/v1/customers?id=YOUR_CUSTOMER_UUID
```

---

## 3️⃣ Update Customer

### `PUT /v1/customers?id={UUID}`

Updates an existing customer's information.

### Request Body

```json
{
  "name": "Updated Book Store",
  "contact": "9999999999",
  "email": "updated@example.com",
  "gstin": "27ABCDE1234F1Z5",
  "fail_existing": "0",
  "notes": {}
}
```

---

## 4️⃣ Fetch All Customers

### `GET /v1/allcustomers`

Fetches customers using `count` and `skip` parameters.

Example:

```text
GET http://localhost:8080/v1/allcustomers?count=10&skip=0
```

### Parameters

| Parameter | Description                  | Default |
| --------- | ---------------------------- | ------: |
| `count`   | Number of customers to fetch |    `10` |
| `skip`    | Number of records to skip    |     `0` |

---

# 🗃️ Database Configuration

The application uses **MySQL** with Spring Data JPA.

Create a database:

```sql
CREATE DATABASE customer_api;
```

Configure your database connection inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/customer_api
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ **Never commit real database passwords, Razorpay keys or other secrets to GitHub.**

For production, use environment variables or a secure secrets manager.

---

# 💳 Razorpay Integration

This project is designed around a customer/payment backend workflow that can communicate with **Razorpay APIs**.

A typical payment flow can be represented as:

```text
Customer
   │
   ▼
Create Customer
   │
   ▼
Spring Boot API
   │
   ├──────────────► MySQL
   │
   ▼
Razorpay
   │
   ▼
Payment / Customer Workflow
```

Razorpay credentials should always be stored securely and should **never** be hard-coded in the source code.

---

# ▶️ How To Run

## 1. Clone the Repository

```bash
git clone https://github.com/Naseem-Ansari123/springboot-razorpay-customer-api.git
```

## 2. Open the Project

```bash
cd springboot-razorpay-customer-api
```

## 3. Configure MySQL

Make sure MySQL is running and update:

```text
src/main/resources/application.properties
```

with your database credentials.

## 4. Build the Project

Windows:

```powershell
.\mvnw.cmd clean install
```

or:

```bash
mvn clean install
```

## 5. Run the Application

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

or:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

---

# 🧪 Testing With Postman

You can test the API using **Postman**.

### Recommended testing sequence

```text
1. Start Spring Boot
        ↓
2. Create Customer
        ↓
3. Copy Customer UUID
        ↓
4. Get Customer
        ↓
5. Update Customer
        ↓
6. Fetch All Customers
```

Example:

```text
POST   /v1/createCustomer
        ↓
GET    /v1/customers?id={UUID}
        ↓
PUT    /v1/customers?id={UUID}
        ↓
GET    /v1/allcustomers
```

---

# 📌 API Summary

| Method | Endpoint                           | Purpose         |
| ------ | ---------------------------------- | --------------- |
| `POST` | `/v1/createCustomer`               | Create customer |
| `GET`  | `/v1/customers?id={UUID}`          | Get customer    |
| `PUT`  | `/v1/customers?id={UUID}`          | Update customer |
| `GET`  | `/v1/allcustomers?count=10&skip=0` | Fetch customers |

---

# 🧠 What I Learned From This Project

This project helped strengthen practical knowledge of:

* Java backend development
* Spring Boot
* REST API architecture
* HTTP methods
* Request/Response handling
* DTO design
* Dependency Injection
* Spring Data JPA
* Hibernate
* MySQL integration
* Maven
* UUID-based resource identification
* API testing with Postman
* Git & GitHub
* Payment-platform API integration concepts

---

# 🔐 Security Notes

Before deploying this project:

* Do not commit `application.properties` containing real credentials.
* Do not expose Razorpay `KEY_SECRET`.
* Use environment variables for secrets.
* Use HTTPS in production.
* Add authentication and authorization for protected endpoints.
* Validate and sanitize incoming API data.

---

# 🔮 Future Improvements

Possible extensions:

* [ ] Complete Razorpay payment/order integration
* [ ] Customer authentication
* [ ] JWT-based authorization
* [ ] Global exception handling
* [ ] Bean Validation
* [ ] Swagger / OpenAPI documentation
* [ ] Proper pagination using Spring Data `Pageable`
* [ ] Unit & integration tests
* [ ] Docker support
* [ ] CI/CD with GitHub Actions
* [ ] Production deployment

---

# 👨‍💻 Author

### Naseem Ansari

**TYBSc Computer Science Student | Java Backend & Full-Stack Developer**

Interested in:

```text
Java • Spring Boot • REST APIs • MERN • DSA • Backend Development
```

### GitHub

🔗 https://github.com/Naseem-Ansari123

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

---

<p align="center">
  Built with ☕ Java + 🌱 Spring Boot + 🐬 MySQL
</p>
