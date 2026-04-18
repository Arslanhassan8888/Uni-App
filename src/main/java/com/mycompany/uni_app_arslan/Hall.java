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

    
}
