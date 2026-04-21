package com.mycompany.uni_app_arslan;

import java.util.ArrayList;

/**
 *
 * @author Arslan Hassan
 */


/*
 Store class stores records for the university halls system.

 This class will be used to keep students, employees halls adn payment  in memory.
*/

public class Store {

    // List to store students
    private ArrayList<Student> students;

    // List to store employees
    private ArrayList<Employee> employees;

    // List to store halls
    private ArrayList<Hall> halls;

    //List to store payments
    private ArrayList<Payment> payments;

    // Current position in student list
    private int studentIndex;

    // Current position in employee list
    private int employeeIndex;

    // Current position in hall list
    private int hallIndex;

    // Current position in payment list
    private int paymentIndex;

    // Constructor

    // Default constructor
    public Store() {

        // Create the student list
        students = new ArrayList<>();

        // Create the employee list
        employees = new ArrayList<>();

        // Create the hall list
        halls = new ArrayList<>();

        // Create the payment list
        payments = new ArrayList<>();

        // Start all indexes at 0
        studentIndex = 0;
        employeeIndex = 0;
        hallIndex = 0;
        paymentIndex = 0;
    }


    //Methods to add data

    // Adds a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Adds an employee to the list
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    // Adds a hall to the list
    public void addHall(Hall hall){
        halls.add(hall);
    }

    // Adds a payment to the list
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    // Returns the next student in the list
    public Student getNextStudent() {

        // Check if the list is empty
        if (students.isEmpty()) {
            return null;
        }

        // If the end is reached, go back to the start
        if (studentIndex >= students.size()) {
            studentIndex = 0;
        }

        // Get the current student
        Student student = students.get(studentIndex);

        // Move to the next position
        studentIndex++;

        return student;
    }

    // Returns the next employee in the list
    public Employee getNextEmployee() {

        // Check if the list is empty
        if (employees.isEmpty()) {
            return null;
        }

        // If the end is reached, go back to the start
        if (employeeIndex >= employees.size()) {
            employeeIndex = 0;
        }

        // Get the current employee
        Employee employee = employees.get(employeeIndex);

        // Move to the next position
        employeeIndex++;

        return employee;
    }

    // Returns the next hall in the list
    public Hall getNextHall() {

        // Check if the list is empty
        if (halls.isEmpty()) {
            return null;
        }

        // If the end is reached, go back to the start
        if (hallIndex >= halls.size()) {
            hallIndex = 0;
        }

        // Get the current hall
        Hall hall = halls.get(hallIndex);

        // Move to the next position
        hallIndex++;

        return hall;
    }

    // Returns the next payment in the list
    public Payment getNextPayment() {

        // Check if the list is empty
        if (payments.isEmpty()) {
            return null;
        }

        // If the end is reached, go back to the start
        if (paymentIndex >= payments.size()) {
            paymentIndex = 0;
        }

        // Get the current payment
        Payment payment = payments.get(paymentIndex);

        // Move to the next position
        paymentIndex++;

        return payment;
    }

    // Returns the student list
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Returns the employee list
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Returns the hall list
    public ArrayList<Hall> getHalls() {
        return halls;
    }

    // Returns the payment list
    public ArrayList<Payment> getPayments() {
        return payments;
    }

    // Clears the student list
    public void clearStudents() {
        students.clear();
        studentIndex = 0;
    }

    // Clears the employee list
    public void clearEmployees() {
        employees.clear();
        employeeIndex = 0;
    }

    // Clears the hall list
    public void clearHalls() {
        halls.clear();
        hallIndex = 0;
    }

    // Clears the payment list
    public void clearPayments() {
        payments.clear();
        paymentIndex = 0;
    }
}