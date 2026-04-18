package com.mycompany.uni_app_arslan;
/**
 *
 * @author Arslan Hassan
 */

/*
 Main class for testing the application.
*/
public class Uni_App_Arslan {

    public static void main(String[] args) {

        // Run one test at a time

        testPerson();
        testStudent();
        testEmployee();
        testHall();
    }

    // Test Person class
    public static void testPerson() {

        Person p = new Person(
                "Ali Khan",
                "Male",
                "01/01/2000",
                "Manchester",
                "British",
                "None",
                "Today"
        );

        System.out.println("Person Test:");
        System.out.println(p);
        System.out.println("-------------------");
    }

    // Test Student class
    public static void testStudent() {

        Student s = new Student(
                "Arslan Hassan",
                "Male",
                "01/01/2000",
                "Manchester",
                "British",
                "None",
                "Today",
                "S1001",
                2,
                "Vegetarian",
                true,
                120.50,
                "Maple Hall",
                false
        );

        System.out.println("Student Test:");
        System.out.println(s);
        System.out.println("-------------------");
    }

    // Test Employee class
    public static void testEmployee() {

        Employee e = new Employee(
                "John Smith",
                "Male",
                "02/02/1985",
                "London",
                "British",
                "None",
                "Today",
                "E2001",
                "Manager",
                2500.00,
                "Oak Hall"
        );

        System.out.println("Employee Test:");
        System.out.println(e);
        System.out.println("-------------------");
    }

    // Test Hall class
    public static void testHall() {

        Hall h = new Hall(
                "Maple Hall",
                "Mixed",
                100,
                true,
                true
        );

        System.out.println("Hall Test:");
        System.out.println(h);
        System.out.println("-------------------");
    }
}