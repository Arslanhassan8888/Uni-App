package com.mycompany.uni_app_arslan;

/**
 *
 * @author Arslan Hassan
 */

/*
 Hall class represents a hall of residence in the university halls system.

 This class stores information about a hall.
*/
public class Hall {

    // Name of the hall
    private String hallName;

    // Type of hall (e.g. mixed, female only, quiet)
    private String hallType;

    // Maximum number of residents
    private int capacity;

    // Is the hall suitable for vegetarian students?
    private boolean vegetarianFriendly;

    // Does the hall have ground floor rooms?
    private boolean groundFloorAvailable;


// Constructors

    // Default constructor
    public Hall() {
    }

    // Full constructor
    public Hall(String hallName, String hallType, int capacity,
                boolean vegetarianFriendly, boolean groundFloorAvailable) {

        this.hallName = hallName;
        this.hallType = hallType;
        this.capacity = capacity;
        this.vegetarianFriendly = vegetarianFriendly;
        this.groundFloorAvailable = groundFloorAvailable;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isVegetarianFriendly() {
        return vegetarianFriendly;
    }

    public void setVegetarianFriendly(boolean vegetarianFriendly) {
        this.vegetarianFriendly = vegetarianFriendly;
    }

    public boolean isGroundFloorAvailable() {
        return groundFloorAvailable;
    }

    public void setGroundFloorAvailable(boolean groundFloorAvailable) {
        this.groundFloorAvailable = groundFloorAvailable;
    }

    // toString method

    @Override
    public String toString() {
        return "Hall: " +
                "Name = " + hallName +
                ", Type = " + hallType +
                ", Capacity = " + capacity +
                ", Vegetarian Friendly = " + vegetarianFriendly +
                ", Ground Floor Available = " + groundFloorAvailable;
    }

}
