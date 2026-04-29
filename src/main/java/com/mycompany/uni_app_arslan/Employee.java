package com.mycompany.uni_app_arslan;

/**
 * Employee class represents a staff member in the university halls system.
 *
 * This class extends Person and inherits common information from the Person class.
 *
 * @author Arslan Hassan
 */
public class Employee extends Person {

    /** Employee ID. */
    private String employeeId;

    /** Job role (e.g. cleaner, manager, security). */
    private String jobRole;

    /** Salary of the employee. */
    private double salary;

    /** Hall name where the employee works or lives. */
    private String hallName;


    /** CONSTRUCTORS */

    /**
     * Default constructor.
     */
    public Employee() {
    }

    /**
     * Full constructor.
     *
     * @param name employee name
     * @param gender employee gender
     * @param dateOfBirth employee date of birth
     * @param address employee address
     * @param nationality employee nationality
     * @param healthConditions employee health conditions
     * @param registrationDate employee registration date
     * @param employeeId employee ID
     * @param jobRole employee job role
     * @param salary employee salary
     * @param hallName hall name where the employee works or lives
     */
    public Employee(String name, String gender, String dateOfBirth, String address,
                    String nationality, String healthConditions, String registrationDate,
                    String employeeId, String jobRole, double salary, String hallName) {

        // Call parent constructor
        super(name, gender, dateOfBirth, address,
                nationality, healthConditions, registrationDate);

        // Set employee fields
        this.employeeId = employeeId;
        this.jobRole = jobRole;
        this.salary = salary;
        this.hallName = hallName;
    }


    /** GETTERS AND SETTERS */

    /**
     * Returns the employee ID.
     *
     * @return employee ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee ID.
     *
     * @param employeeId employee ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Returns the job role.
     *
     * @return job role
     */
    public String getJobRole() {
        return jobRole;
    }

    /**
     * Sets the job role.
     *
     * @param jobRole job role
     */
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    /**
     * Returns the salary.
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     *
     * @param salary salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the hall name.
     *
     * @return hall name
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * Sets the hall name.
     *
     * @param hallName hall name
     */
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * Returns the role of the person.
     *
     * @return Employee
     */
    @Override
    public String getRole() {
        return "Employee";
    }

    /** toString method */

    /**
     * Returns a readable version of the employee object.
     *
     * @return employee details as a string
     */
    @Override
    public String toString() {
        return "Employee: " +
                "Name = " + getName() +
                ", ID = " + employeeId +
                ", Role = " + jobRole +
                ", Salary = " + salary +
                ", Hall = " + hallName;
    }
}