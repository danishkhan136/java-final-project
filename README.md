# Contact Book Management System

A desktop-based **Contact Book Management System** developed in **Java Swing** with **MySQL database connectivity**. This project was created as my **2nd semester final project** during my Software Engineering degree.

The application allows users to log in, request access, save contact information, and search saved contacts using a simple graphical user interface.

---

## Project Overview

The main purpose of this project is to manage personal contact records in a structured way. Instead of storing contacts manually in notebooks or text files, this application stores contact details in a MySQL database and provides a Java GUI to add and retrieve records.

This project helped me practice core software engineering concepts such as:

- Java GUI development
- Object-oriented programming
- Database connectivity
- CRUD-style application logic
- Form handling and validation
- Multi-window desktop application flow

---

## Features

- **Login System**  
  Users can log in with a username and password stored in the database.

- **Request Access Page**  
  New users can submit an access request with name, reason, username, and password.

- **Main Selection Page**  
  After login, users can choose between saving a new contact or searching an existing contact.

- **Save Contact**  
  Users can store contact details including first name, last name, phone number, address, email, and nickname.

- **Search Contact**  
  Users can search contact details by entering a nickname or first name.

- **MySQL Database Integration**  
  The application connects to a local MySQL database named `contactbook`.

- **Simple Desktop Interface**  
  Built using Java Swing components such as `JFrame`, `JPanel`, `JLabel`, `JTextField`, `JPasswordField`, and `JButton`.

---

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Java Swing | Desktop GUI development |
| MySQL | Database storage |
| JDBC | Java database connectivity |
| Eclipse IDE | Project development environment |
| MySQL Connector/J | Driver for Java-MySQL connection |

---

## Project Structure

```text
java-final-project/
└── Contact Book/
    ├── src/
    │   └── contactbook/
    │       ├── loginpage.java
    │       ├── askforaccess.java
    │       ├── choosepage.java
    │       ├── savecontact.java
    │       └── getcontact.java
    ├── .classpath
    ├── .project
    └── .gitignore
```

---

## Main Java Files

| File | Description |
|---|---|
| `loginpage.java` | Login screen for existing users |
| `askforaccess.java` | Access request form for new users |
| `choosepage.java` | Main menu after successful login |
| `savecontact.java` | Form to save new contact details |
| `getcontact.java` | Screen to search and display saved contacts |

---

## Database Setup

Create a MySQL database named:

```sql
CREATE DATABASE contactbook;
USE contactbook;
```

Create the required tables:

```sql
CREATE TABLE login (
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE contacts (
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    phonenumber VARCHAR(50),
    address VARCHAR(255),
    email VARCHAR(150),
    nickname VARCHAR(100)
);

CREATE TABLE request (
    name VARCHAR(100),
    reason VARCHAR(255),
    username VARCHAR(100),
    password VARCHAR(100)
);
```

Add a sample login user:

```sql
INSERT INTO login VALUES ('admin', 'admin123');
```

---

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/danishkhan136/java-final-project.git
```

### 2. Open in Eclipse

1. Open **Eclipse IDE**.
2. Go to **File > Import**.
3. Select **Existing Projects into Workspace**.
4. Choose the `Contact Book` project folder.
5. Click **Finish**.

### 3. Add MySQL Connector/J

The project requires the MySQL JDBC driver.

1. Download **MySQL Connector/J**.
2. Right-click the project in Eclipse.
3. Go to **Build Path > Configure Build Path**.
4. Open the **Libraries** tab.
5. Add the MySQL connector `.jar` file.
6. Apply and close.

### 4. Start MySQL Server

Make sure MySQL is running and the `contactbook` database has been created.

The database connection used in the project is:

```java
jdbc:mysql://localhost/contactbook
Username: root
Password: empty
```

### 5. Run the Application

Run this file:

```text
src/contactbook/loginpage.java
```

---

## Application Flow

```text
Login Page
   |
   |-- Successful Login --> Choose Page
   |                         |
   |                         |-- Save Contact
   |                         |
   |                         |-- Get Contact
   |
   |-- Ask for Access --> Request Access Form
```

---

## Screenshots

You can add screenshots of your project here:

```md
![Login Page](screenshots/login-page.png)
![Save Contact Page](screenshots/save-contact.png)
![Get Contact Page](screenshots/get-contact.png)
```

---

## What I Learned

While building this project, I learned how to:

- Design desktop applications using Java Swing
- Connect Java applications with MySQL using JDBC
- Use multiple JFrame windows in one application
- Insert and retrieve data from a database
- Validate user input before storing records
- Organize Java files into packages
- Build a complete academic software project from start to finish

---

## Future Improvements

- Add update and delete contact features
- Add password hashing for better security
- Improve UI design and layout
- Add input validation for email and phone number
- Add search by phone number or email
- Add admin approval for access requests
- Add a table view to display all contacts
- Export contacts to CSV or PDF

---

## Author

**Danish Khan**  
Software Engineering Student  
Project: 2nd Semester Final Project  
GitHub: [danishkhan136](https://github.com/danishkhan136)

---

## Repository

[Java Final Project - Contact Book](https://github.com/danishkhan136/java-final-project)

---

## License

This project is created for academic and learning purposes. You are free to use it as a reference for Java Swing and MySQL-based desktop applications.

---

## Final Note

This project represents my early practical work in Java and database programming during the second semester of my Software Engineering degree. It helped me understand how real software applications connect user interfaces with databases.
