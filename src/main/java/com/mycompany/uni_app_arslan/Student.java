package com.mycompany.uni_app_arslan;

/**
 * Student class represents a student in the university halls system.
 *
 * This class extends Person and inherits common fields such as
 * name, gender, date of birth, address, nationality, and other shared details.
 *
 * It adds fields that are specific to students.
 *
 * @author Arslan Hassan
 */
public class Student extends Person {

    /** Unique student ID. */
    private String studentId;

    /** Year of study (1, 2, 3, etc.). */
    private int yearOfStudy;

    /** Dietary preference (e.g. vegetarian, vegan). */
    private String dietaryPreference;

    /** Indicates if the student requires a ground floor room. */
    private boolean groundFloorRequired;

    /** Rent amount for the student. */
    private double rentAmount;

    /** Name of the hall the student is assigned to. */
    private String hallName;

    /** Indicates if the student is a senior helper. */
    private boolean seniorStudent;


    /** CONSTRUCTORS */

    /**
     * Default constructor.
     * Creates an empty Student object.
     */
    public Student() {
    }

    /**
     * Full constructor.
     *
     * @param name student's name
     * @param gender student's gender
     * @param dateOfBirth student's date of birth
     * @param address student's address
     * @param nationality student's nationality
     * @param healthConditions student's health conditions
     * @param registrationDate registration date
     * @param studentId unique student ID
     * @param yearOfStudy year of study
     * @param dietaryPreference dietary preference
     * @param groundFloorRequired true if a ground floor room is required
     * @param rentAmount rent amount
     * @param hallName assigned hall name
     * @param seniorStudent true if the student is a senior helper
     */
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

    /** GETTERS AND SETTERS */

    /**
     * Returns the student ID.
     *
     * @return student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId student ID
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns the year of study.
     *
     * @return year of study
     */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Sets the year of study.
     *
     * @param yearOfStudy year of study
     */
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * Returns the dietary preference.
     *
     * @return dietary preference
     */
    public String getDietaryPreference() {
        return dietaryPreference;
    }

    /**
     * Sets the dietary preference.
     *
     * @param dietaryPreference dietary preference
     */
    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }

    /**
     * Returns true if a ground floor room is required.
     *
     * @return ground floor requirement
     */
    public boolean isGroundFloorRequired() {
        return groundFloorRequired;
    }

    /**
     * Sets the ground floor requirement.
     *
     * @param groundFloorRequired ground floor requirement
     */
    public void setGroundFloorRequired(boolean groundFloorRequired) {
        this.groundFloorRequired = groundFloorRequired;
    }

    /**
     * Returns the rent amount.
     *
     * @return rent amount
     */
    public double getRentAmount() {
        return rentAmount;
    }

    /**
     * Sets the rent amount.
     *
     * @param rentAmount rent amount
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
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
     * Returns true if the student is a senior helper.
     *
     * @return senior student status
     */
    public boolean isSeniorStudent() {
        return seniorStudent;
    }

    /**
     * Sets the senior student status.
     *
     * @param seniorStudent senior student status
     */
    public void setSeniorStudent(boolean seniorStudent) {
        this.seniorStudent = seniorStudent;
    }

    /**
     * Returns the role of the person.
     *
     * @return Student
     */
    @Override
    public String getRole() {
        return "Student";
    }

    /** toString method */

    /**
     * Returns a readable version of the student object.
     *
     * @return student details as a string
     */
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