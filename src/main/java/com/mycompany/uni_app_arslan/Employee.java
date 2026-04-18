package com.mycompany.uni_app_arslan;

/**
 * The Employee class represents an employee in the university halls system.
 *
 * @author Arslan Hassan
 */
/*
 Employee class represents a staff member in the university halls system.

 This class extends Person.
 It will inherit common information from the Person class.
*/
public class Employee extends Person {

    // Employee ID
    private String employeeId;

    // Job role (e.g. cleaner, manager, security)
    private String jobRole;

    // Salary of the employee
    private double salary;

    // Hall name where the employee works or lives
    private String hallName;

}