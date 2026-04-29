package com.mycompany.uni_app_arslan;

/**
 * Person class represents a general person in the university halls system.
 *
 * This is an abstract parent class that stores common information shared
 * by both students and employees.
 *
 * @author Arslan Hassan
 */
public abstract class Person {

    /**
     * The full name of the person.
     *
     * This field is private to ensure it cannot be directly modified
     * without using getter and setter methods.
     */
    private String name;

    /** The gender of the person. */
    private String gender;

    /** The person's date of birth. */
    private String dateOfBirth;

    /** The home address of the person. */
    private String address;

    /** The nationality of the person. */
    private String nationality;

    /** Any health conditions of the person. */
    private String healthConditions;

    /** The date when the record was added to the system. */
    private String registrationDate;

    /** CONSTRUCTORS */

    /**
     * Default constructor.
     * Creates a Person object with no initial values.
     */
    public Person() {
    }

    /**
     * Full constructor.
     *
     * @param name person's name
     * @param gender person's gender
     * @param dateOfBirth person's date of birth
     * @param address person's address
     * @param nationality person's nationality
     * @param healthConditions person's health conditions
     * @param registrationDate date when the record was added
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

    /** GETTERS AND SETTERS */

    /**
     * Returns the person's name.
     *
     * @return person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the person's name.
     *
     * @param name person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the person's gender.
     *
     * @return person's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the person's gender.
     *
     * @param gender person's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the person's date of birth.
     *
     * @return date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the person's date of birth.
     *
     * @param dateOfBirth date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the person's address.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the person's address.
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the person's nationality.
     *
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the person's nationality.
     *
     * @param nationality nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Returns the person's health conditions.
     *
     * @return health conditions
     */
    public String getHealthConditions() {
        return healthConditions;
    }

    /**
     * Sets the person's health conditions.
     *
     * @param healthConditions health conditions
     */
    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }

    /**
     * Returns the registration date.
     *
     * @return registration date
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the registration date.
     *
     * @param registrationDate registration date
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Returns the role of the person.
     *
     * This method must be implemented by subclasses.
     *
     * @return role of the person
     */
    public abstract String getRole();

    /** toString method */

    /**
     * Returns a readable version of the object.
     *
     * @return person details as a string
     */
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