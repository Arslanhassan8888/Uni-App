package com.mycompany.uni_app_arslan;
import javax.swing.*;
/**
 *
 * @author Arslan Hassan
 */

/*
 Main class for testing the application.
 And for the University Hall
*/
public class Uni_App_Arslan {

    public static void main(String[] args) {

        // Run one test at a time

//        testPerson();
//        testStudent();
//        testEmployee();
//        testHall();
//        testStore();
//    }


        // Create the main window
        JFrame frame = new JFrame("University Halls System");

        // Close program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);





    }









}











//    // Test Person class
//    public static void testPerson() {
//
//        Person p = new Person(
//                "Ali Khan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today"
//        );
//
//        System.out.println("Person Test:");
//        System.out.println(p);
//        System.out.println("-------------------");
//    }
//
//    // Test Student class
//    public static void testStudent() {
//
//        Student s = new Student(
//                "Arslan Hassan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today",
//                "S1001",
//                2,
//                "Vegetarian",
//                true,
//                120.50,
//                "Maple Hall",
//                false
//        );
//
//        System.out.println("Student Test:");
//        System.out.println(s);
//        System.out.println("-------------------");
//    }
//
//    // Test Employee class
//    public static void testEmployee() {
//
//        Employee e = new Employee(
//                "John Smith",
//                "Male",
//                "02/02/1985",
//                "London",
//                "British",
//                "None",
//                "Today",
//                "E2001",
//                "Manager",
//                2500.00,
//                "Oak Hall"
//        );
//
//        System.out.println("Employee Test:");
//        System.out.println(e);
//        System.out.println("-------------------");
//    }
//
//    // Test Hall class
//    public static void testHall() {
//
//        Hall h = new Hall(
//                "Maple Hall",
//                "Mixed",
//                100,
//                true,
//                true
//        );
//
//        System.out.println("Hall Test:");
//        System.out.println(h);
//        System.out.println("-------------------");
//    }
//
//    // Test Store class
//    public static void testStore() {
//
//        // Create a Store object
//        Store store = new Store();
//
//        // Create students
//        Student s1 = new Student(
//                "Ali Khan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today",
//                "S1001",
//                1,
//                "Vegetarian",
//                true,
//                120.50,
//                "Maple Hall",
//                false
//        );
//
//        Student s2 = new Student(
//                "Sara Ahmed",
//                "Female",
//                "02/02/2001",
//                "Leeds",
//                "British",
//                "Asthma",
//                "Today",
//                "S1002",
//                2,
//                "Vegan",
//                false,
//                130.00,
//                "Oak Hall",
//                true
//        );
//
//        // Create employee
//        Employee e1 = new Employee(
//                "John Smith",
//                "Male",
//                "10/10/1985",
//                "London",
//                "British",
//                "None",
//                "Today",
//                "E2001",
//                "Manager",
//                2500.00,
//                "Maple Hall"
//        );
//
//        // Create hall
//        Hall h1 = new Hall(
//                "Maple Hall",
//                "Mixed",
//                100,
//                true,
//                true
//        );
//
//        // Add objects to Store
//        store.addStudent(s1);
//        store.addStudent(s2);
//        store.addEmployee(e1);
//        store.addHall(h1);
//
//        // Display next student records
//        System.out.println("Store Student Test:");
//        System.out.println(store.getNextStudent());
//        System.out.println(store.getNextStudent());
//        System.out.println(store.getNextStudent());
//        System.out.println("-------------------");
//
//        // Display next employee record
//        System.out.println("Store Employee Test:");
//        System.out.println(store.getNextEmployee());
//        System.out.println("-------------------");
//
//        // Display next hall record
//        System.out.println("Store Hall Test:");
//        System.out.println(store.getNextHall());
//        System.out.println("-------------------");
//