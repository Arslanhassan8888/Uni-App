# University Hall Management System

The **University Hall Management System** is a Java-based desktop application developed using **Swing**.  
It is designed to manage students, employees, halls, and payments within a university accommodation environment.

The project focuses on **clear structure**, **form validation**, **object-oriented design**, **file handling**, and a **user-friendly interface**.

---

## Overview

This application allows users to:

- manage student and employee records  
- assign halls based on conditions (diet, health, floor requirement)  
- track rent payments and balances  
- search for individuals by ID  
- save and load records from files  
- navigate records easily through a graphical interface  

The system is built using **Java**, **Swing**, and **text file storage**, following a modular and organised approach.

---

## Installation and Setup

### Requirements

- Java JDK (8 or higher)  
- Any Java IDE (e.g. IntelliJ, Eclipse, NetBeans)  

---

### Compile the Project

```bash
javac com/mycompany/uni_app_arslan/*.java
```
---

## Run the Application

java com.mycompany.uni_app_arslan.Uni_App_Arslan
---

## Technologies Used

### Backend / Logic
- Java
- Object-Oriented Programming (OOP)
- ArrayList (in-memory storage)
- File I/O (text files)

### Frontend
- Java Swing (GUI)
- AWT (layouts and components)
- 
### Tools
- Visual Studio Code / IntelliJ / NetBeans
- Git
- GitHub
---

## Design Decisions
- Swing was used for desktop GUI development
- ArrayList used for simple in-memory data management
- Text files used for persistence instead of a database
- Inheritance implemented via the Person base class
- Separate UI classes for better maintainability
- Validation logic added to improve data accuracy
---

## Key Features

### Student Management
- add new students
- validate student input fields
- assign halls automatically based on:
  - dietary preference
  - health conditions
  - ground floor requirement
- view student records
- cycle through records using "Next"
  
### Employee Management
- add employee records
- assign job roles and halls
- validate salary and ID inputs
- display employee records clearly

### Hall Management
- assign halls to students or employees
- automatic hall allocation based on:
  - health conditions → ground floor
  - vegetarian → first floor
  - vegan → second floor
- manual selection for standard cases
- validation of resident ID
  
### Payment Management
- record student payments
- calculate:
    - rent amount
    - amount paid
    - remaining balance
- automatically determine status:
    - Paid
    - Pending
- link payments to student records

### Search System
- search by ID
- supports:
  - student search
  - employee search
- colour-coded results:
  - green → student
-  blue → employee
- validation for incorrect input

### File Management
- save records to text files:
  - students.txt
  - employees.txt
  - halls.txt
  - payments.txt
- load records back into memory
- overwrite previous data when loading

### Navigation and Controls
- Save Record
- Next Record
- Clear Form
- Save to File
- Load from File
- Delete Tab Records
- Validation and Error Handling
---

## The system includes full validation for user input.

### Validation includes:
- empty field checks
- numeric ID validation
- positive number checks
- valid salary and rent inputs
- valid year of study (1–3)
- valid payment inputs

### Error handling includes:
- inline error messages
- dialogue alerts (JOptionPane)
- safe handling of invalid input
- prevention of incorrect data entry
---

## Project Structure

```
com/mycompany/uni_app_arslan/
│
├── Uni_App_Arslan.java     (main application entry)
├── Store.java              (in-memory data storage)
├── FileManager.java        (file saving/loading)
│
├── Person.java             (abstract base class)
├── Student.java            (student model)
├── Employee.java           (employee model)
├── Hall.java               (hall model)
├── Payment.java            (payment model)
│
├── StudentUI.java          (student interface)
├── EmployeeUI.java         (employee interface)
├── HallUI.java             (hall interface)
├── PaymentUI.java          (payment interface)
├── SearchUI.java           (search interface)
```
---

## Future Improvements

### Database Integration
- replace text files with MySQL or PostgreSQL
- implement a structured relational database

### User Interface Improvements
- improve layout responsiveness
- modernise visual design
- add icons and enhanced styling

### Additional Features
- login and authentication system
- role-based access (admin/user)
- reporting system (PDF export)
- dashboard with analytics

### Code Improvements
- apply MVC architecture
- reduce code duplication
- improve separation of concerns
- introduce unit testing
---

## Author

### Arslan Hassan







