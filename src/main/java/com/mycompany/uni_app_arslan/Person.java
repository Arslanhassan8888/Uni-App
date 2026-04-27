package com.mycompany.uni_app_arslan;

/**
 * Person class represents a general person in the university halls system.
 *
 * This class is a parent class.
 * It stores common information shared by students and employees.
 *
 * @author Arslan Hassan
 */
public abstract class Person {

    /**
     * I used private so other classes cannot directly change data
     * without using getter and setter
     *
     * The full name of the person
     */
    private String name;

    /** The gender of the person */
    private String gender;

    /** The person's date of birth */
    private String dateOfBirth;

    /** The home address of the person */
    private String address;

    /** The nationality of the person */
    private String nationality;

    /** Any health conditions */
    private String healthConditions;

    /** The date when the record was added to the system */
    private String registrationDate;

    /** Constructors */

    /**
     * Default constructor.
     * Creates a Person object with no initial values.
     */
    public Person() {
    }

    /**
     * Full constructor.
     * Creates a Person object with all fields set at once.
     */
    public Person(String name, String gender, String dateOfBirth, String address,
                  String nationality, String healthConditions, String registrationDate) {

        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
        this.healthConditions = healthConditions;
        this.registrationDate = registrationDate;
    }

    /** Getters and setters */

    /** Gets the person's name. */
    public String getName() {
        return name;
    }

    /** Sets the person's name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Gets the person's gender. */
    public String getGender() {
        return gender;
    }

    /** Sets the person's gender. */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Gets the person's date of birth. */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /** Sets the person's date of birth. */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /** Gets the person's address. */
    public String getAddress() {
        return address;
    }

    /** Sets the person's address. */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Gets the person's nationality. */
    public String getNationality() {
        return nationality;
    }

    /** Sets the person's nationality. */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /** Gets the person's health conditions. */
    public String getHealthConditions() {
        return healthConditions;
    }

    /** Sets the person's health conditions. */
    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }

    /** Gets the registration date. */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /** Sets the registration date. */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /** Gets the role of the person. */
    public abstract String getRole();

    /** toString method */

    /** Returns a readable version of the object. */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", healthConditions='" + healthConditions + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}