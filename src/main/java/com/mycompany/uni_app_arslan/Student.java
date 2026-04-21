package com.mycompany.uni_app_arslan;
/**
 *
 * @author Arslan Hassan
 */

/*
 Student class represents a student in the university halls system.

 This class extends Person.
 This means Student inherits common fields such as:
 name, gender, dateOfBirth, address, nationality, etc.

 We only add fields that are specific to students.
*/
public class Student extends Person {

    // Unique student ID
    private String studentId;

    // Year of study (1, 2, 3, etc.)
    private int yearOfStudy;

    // Dietary preference (e.g. vegetarian, vegan)
    private String dietaryPreference;

    // Does the student need a ground floor room?
    private boolean groundFloorRequired;

    // Rent amount for the student
    private double rentAmount;

    // Name of the hall the student is assigned to
    private String hallName;

    // Indicates if the student is a senior helper
    private boolean seniorStudent;



    // Constructors


    // Default constructor
    // Creates an empty Student object
    public Student() {
    }

    // Full constructor
    // This sets all values when creating a Student object
    public Student(String name, String gender, String dateOfBirth, String address,
                   String nationality, String healthConditions, String registrationDate,
                   String studentId, int yearOfStudy, String dietaryPreference,
                   boolean groundFloorRequired, double rentAmount,
                   String hallName, boolean seniorStudent) {

        // Call the Person constructor to set common fields
        // This avoids repeating code from the parent class
        super(name, gender, dateOfBirth, address,
                nationality, healthConditions, registrationDate);

        // Set student-specific fields
        this.studentId = studentId;
        this.yearOfStudy = yearOfStudy;
        this.dietaryPreference = dietaryPreference;
        this.groundFloorRequired = groundFloorRequired;
        this.rentAmount = rentAmount;
        this.hallName = hallName;
        this.seniorStudent = seniorStudent;
    }

    // Getters and Setters


    // Returns the student ID
    public String getStudentId() {
        return studentId;
    }

    // Sets the student ID
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Returns the year of study
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    // Sets the year of study
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    // Returns the dietary preference
    public String getDietaryPreference() {
        return dietaryPreference;
    }

    // Sets the dietary preference
    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }

    // Returns true if ground floor room is required
    public boolean isGroundFloorRequired() {
        return groundFloorRequired;
    }

    // Sets ground floor requirement
    public void setGroundFloorRequired(boolean groundFloorRequired) {
        this.groundFloorRequired = groundFloorRequired;
    }

    // Returns the rent amount
    public double getRentAmount() {
        return rentAmount;
    }

    // Sets the rent amount
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    // Returns the hall name
    public String getHallName() {
        return hallName;
    }

    // Sets the hall name
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    // Returns true if student is a senior helper
    public boolean isSeniorStudent() {
        return seniorStudent;
    }

    // Sets senior student status
    public void setSeniorStudent(boolean seniorStudent) {
        this.seniorStudent = seniorStudent;
    }

    /* Gets the role of the person. */
    @Override
    public String getRole() {
        return "Student";
    }
    // toString method

    // Returns a readable version of the student object
    // Useful for testing and debugging
    @Override
    public String toString() {
        return "Student: " +
                "Name = " + getName() +
                ", ID = " + studentId +
                ", Year = " + yearOfStudy +
                ", Diet = " + dietaryPreference +
                ", Ground Floor = " + groundFloorRequired +
                ", Rent = " + rentAmount +
                ", Hall = " + hallName +
                ", Senior = " + seniorStudent;
    }
}