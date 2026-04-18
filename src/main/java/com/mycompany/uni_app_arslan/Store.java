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

    // Constructor

    // Default constructor
    public Store() {

        // Create the student list
        students = new ArrayList<>();

        // Create the employee list
        employees = new ArrayList<>();

        // Create the hall list
        halls = new ArrayList<>();
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
}