package com.mycompany.uni_app_arslan;
import java.util.ArrayList;

/**
 *
 * @author Arslan Hassan
 */


/*
 Store class stores records for the university halls system.

 This class will be used to keep students and employees in memory.
*/

public class Store {

    // List to store students
    private ArrayList<Student> students;

    // List to store employees
    private ArrayList<Employee> employees;

    // List to store halls
    private ArrayList<Hall> halls;

    // Current position in student list
    private int studentIndex;

    // Current position in employee list
    private int employeeIndex;

    // Current position in hall list
    private int hallIndex;

    // Constructor

    // Default constructor
    public Store() {

        // Create the student list
        students = new ArrayList<>();

        // Create the employee list
        employees = new ArrayList<>();

        // Create the hall list
        halls = new ArrayList<>();

        // Start all indexes at 0
        studentIndex = 0;
        employeeIndex = 0;
        hallIndex = 0;
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
}