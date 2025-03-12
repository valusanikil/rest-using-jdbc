# rest-using-jdbc

Here's a sample `README.md` file for your Java REST API project with JDBC:

---

# Customer Management REST API

## 📝 **Project Overview**  
This project is a RESTful web service for managing customer information. The application is built using **Java** with **Spring Boot** and **JDBC** for database connectivity. It provides basic CRUD (Create, Read, Update, Delete) operations on customer data stored in a **MySQL** database.

---

## 🚀 **Technologies Used**  
- **Java** (JDK 8 or higher)  
- **Spring Boot**  
- **JDBC (Java Database Connectivity)**  
- **MySQL**  
- **Maven**  
- **Postman** (for API testing)  

---

## 📂 **Project Structure**  
```
src/main/java/com/rest
├── controller
│   └── CustomerController.java
├── entity
│   └── Customer.java
├── exception
│   └── GlobalException.java
├── repository
│   ├── CustomerRepository.java
│   └── CustomerRepositoryImpl.java
├── service
│   ├── CustomerService.java
│   └── CustomerServiceImpl.java
└── Application.java
```

---

## 🌐 **API Endpoints**  

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/customers/customer` | Add a new customer |
| `GET`  | `/customers` | Get all customers |
| `GET`  | `/customers/{id}` | Get customer by ID |
| `DELETE` | `/customers/{id}` | Delete customer by ID |
| `PUT`  | `/customers/customer` | Update customer details |

---

## 💡 **Features**  
✅ Create a new customer  
✅ Fetch all customers  
✅ Fetch customer by ID  
✅ Update customer details  
✅ Delete customer by ID  
✅ Global exception handling for `NullPointerException`  

---

## 🛠️ **Setup and Installation**  

### 1. **Clone the repository**  
```sh
git clone https://github.com/your-username/your-repo.git
```

### 2. **Set up the MySQL Database**  
Create a database named **RestApiJDBCDatabase** and create a table `customer_info` using the following SQL script:
```sql
CREATE DATABASE RestApiJDBCDatabase;
USE RestApiJDBCDatabase;

CREATE TABLE customer_info (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(15)
);
```

### 3. **Configure Database Connection**  
Update the `CustomerRepositoryImpl.java` file with your MySQL credentials:
```java
String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
String user = "root";
String password = "your-password";
```

### 4. **Build and Run**  
Use Maven to build and run the project:
```sh
mvn clean install
mvn spring-boot:run
```

---

## 📬 **Testing**  
You can test the API using **Postman** or **cURL**. Example:

**Add Customer:**
```sh
POST /customers/customer
{
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "123-456-7890"
}
```

**Get All Customers:**
```sh
GET /customers
```

---

## 🚀 **Future Enhancements**  
- Add pagination and sorting for fetching customer data  
- Implement JWT-based authentication  
- Add input validation and better error handling  
