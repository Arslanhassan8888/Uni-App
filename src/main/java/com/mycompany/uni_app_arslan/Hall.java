package com.mycompany.uni_app_arslan;

/**
 * Hall class represents a hall record in the university halls system.
 *
 * This class stores information about:
 * hall name,
 * hall type,
 * resident type (student or employee),
 * resident ID,
 * room type,
 * vegetarian suitability,
 * and vegan suitability.
 *
 * @author Arslan Hassan
 */
public class Hall {

    /** Name of the hall. */
    private String hallName;

    /** Type of hall (e.g. mixed, female only, quiet). */
    private String hallType;

    /** Indicates whether the hall record is for a student or employee. */
    private String residentType;

    /** ID of the student or employee. */
    private String residentId;

    /** Room type (e.g. 1 Person, 2 Person). */
    private String roomType;

    /** Indicates if the hall is suitable for vegetarian people. */
    private boolean vegetarianFriendly;

    /** Indicates if the hall is suitable for vegan people. */
    private boolean veganFriendly;

    /** CONSTRUCTORS */

    /**
     * Default constructor.
     */
    public Hall() {
    }

    /**
     * Full constructor.
     *
     * @param hallName name of the hall
     * @param hallType type of hall
     * @param residentType type of resident (student or employee)
     * @param residentId ID of the resident
     * @param roomType type of room
     * @param vegetarianFriendly true if suitable for vegetarians
     * @param veganFriendly true if suitable for vegans
     */
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

    /** GETTERS AND SETTERS */

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
     * Returns the hall type.
     *
     * @return hall type
     */
    public String getHallType() {
        return hallType;
    }

    /**
     * Sets the hall type.
     *
     * @param hallType hall type
     */
    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    /**
     * Returns the resident type.
     *
     * @return resident type
     */
    public String getResidentType() {
        return residentType;
    }

    /**
     * Sets the resident type.
     *
     * @param residentType resident type
     */
    public void setResidentType(String residentType) {
        this.residentType = residentType;
    }

    /**
     * Returns the resident ID.
     *
     * @return resident ID
     */
    public String getResidentId() {
        return residentId;
    }

    /**
     * Sets the resident ID.
     *
     * @param residentId resident ID
     */
    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    /**
     * Returns the room type.
     *
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type.
     *
     * @param roomType room type
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Returns true if the hall is suitable for vegetarians.
     *
     * @return vegetarian suitability
     */
    public boolean isVegetarianFriendly() {
        return vegetarianFriendly;
    }

    /**
     * Sets vegetarian suitability.
     *
     * @param vegetarianFriendly vegetarian suitability
     */
    public void setVegetarianFriendly(boolean vegetarianFriendly) {
        this.vegetarianFriendly = vegetarianFriendly;
    }

    /**
     * Returns true if the hall is suitable for vegans.
     *
     * @return vegan suitability
     */
    public boolean isVeganFriendly() {
        return veganFriendly;
    }

    /**
     * Sets vegan suitability.
     *
     * @param veganFriendly vegan suitability
     */
    public void setVeganFriendly(boolean veganFriendly) {
        this.veganFriendly = veganFriendly;
    }

    /** toString method */

    /**
     * Returns a readable version of the hall object.
     *
     * @return hall details as a string
     */
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