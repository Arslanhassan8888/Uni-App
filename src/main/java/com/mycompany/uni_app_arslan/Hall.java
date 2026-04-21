package com.mycompany.uni_app_arslan;

/**
 *
 * @author Arslan Hassan
 */

/*
 Hall class represents a hall record in the university halls system.

 This class stores information about:
 hall name
 hall type
 who the hall record is for
 the related person ID
 room type
 vegetarian option
 vegan option
*/
public class Hall {

    // Name of the hall
    private String hallName;

    // Type of hall (e.g. mixed, female only, quiet)
    private String hallType;

    // Is this hall record for a student or employee?
    private String residentType;

    // ID of the student or employee
    private String residentId;

    // Room type (e.g. 1 Person, 2 Person)
    private String roomType;

    // Is the hall suitable for vegetarian people?
    private boolean vegetarianFriendly;

    // Is the hall suitable for vegan people?
    private boolean veganFriendly;

    // Constructors

    // Default constructor
    public Hall() {
    }

    // Full constructor
    public Hall(String hallName, String hallType, String residentType,
                String residentId, String roomType,
                boolean vegetarianFriendly, boolean veganFriendly) {

        this.hallName = hallName;
        this.hallType = hallType;
        this.residentType = residentType;
        this.residentId = residentId;
        this.roomType = roomType;
        this.vegetarianFriendly = vegetarianFriendly;
        this.veganFriendly = veganFriendly;
    }

    // Getters and Setters

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public String getResidentType() {
        return residentType;
    }

    public void setResidentType(String residentType) {
        this.residentType = residentType;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isVegetarianFriendly() {
        return vegetarianFriendly;
    }

    public void setVegetarianFriendly(boolean vegetarianFriendly) {
        this.vegetarianFriendly = vegetarianFriendly;
    }

    public boolean isVeganFriendly() {
        return veganFriendly;
    }

    public void setVeganFriendly(boolean veganFriendly) {
        this.veganFriendly = veganFriendly;
    }

    // toString method

    @Override
    public String toString() {
        return "Hall: " +
                "Hall Name = " + hallName +
                ", Hall Type = " + hallType +
                ", Resident Type = " + residentType +
                ", Resident ID = " + residentId +
                ", Room Type = " + roomType +
                ", Vegetarian Friendly = " + vegetarianFriendly +
                ", Vegan Friendly = " + veganFriendly;
    }
}