package com.mycompany.uni_app_arslan;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * FileManager class handles saving and loading records.
 *
 * This version uses Java Serialization instead of plain text.
 *
 * Data is still saved in text files:
 * students.txt, employees.txt, halls.txt, payments.txt
 *
 * However, the content is now stored as serialized objects
 * (binary format), making it unreadable and more secure.
 *
 * @author Arslan Hassan
 */
public class FileManager {

    /** File name for student records. */
    private static final String STUDENT_FILE = "students.txt";

    /** File name for employee records. */
    private static final String EMPLOYEE_FILE = "employees.txt";

    /** File name for hall records. */
    private static final String HALL_FILE = "halls.txt";

    /** File name for payment records. */
    private static final String PAYMENT_FILE = "payments.txt";


    /**
     * Saves all student records to file using serialization.
     *
     * @param store the store containing student records
     */
    public static void saveStudents(Store store) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(STUDENT_FILE)
            );

            out.writeObject(store.getStudents());
            out.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving student records.");
        }
    }


    /**
     * Loads all student records from file using serialization.
     *
     * @param store the store where student records will be loaded
     */
    public static void loadStudents(Store store) {

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(STUDENT_FILE)
            );

            ArrayList<Student> students = (ArrayList<Student>) in.readObject();
            in.close();

            store.clearStudents();

            for (Student student : students) {
                store.addStudent(student);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading student records.");
        }
    }


    /**
     * Saves all employee records to file using serialization.
     *
     * @param store the store containing employee records
     */
    public static void saveEmployees(Store store) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(EMPLOYEE_FILE)
            );

            out.writeObject(store.getEmployees());
            out.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving employee records.");
        }
    }


    /**
     * Loads all employee records from file using serialization.
     *
     * @param store the store where employee records will be loaded
     */
    public static void loadEmployees(Store store) {

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(EMPLOYEE_FILE)
            );

            ArrayList<Employee> employees = (ArrayList<Employee>) in.readObject();
            in.close();

            store.clearEmployees();

            for (Employee employee : employees) {
                store.addEmployee(employee);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading employee records.");
        }
    }


    /**
     * Saves all hall records to file using serialization.
     *
     * @param store the store containing hall records
     */
    public static void saveHalls(Store store) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(HALL_FILE)
            );

            out.writeObject(store.getHalls());
            out.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving hall records.");
        }
    }


    /**
     * Loads all hall records from file using serialization.
     *
     * @param store the store where hall records will be loaded
     */
    public static void loadHalls(Store store) {

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(HALL_FILE)
            );

            ArrayList<Hall> halls = (ArrayList<Hall>) in.readObject();
            in.close();

            store.clearHalls();

            for (Hall hall : halls) {
                store.addHall(hall);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading hall records.");
        }
    }


    /**
     * Saves all payment records to file using serialization.
     *
     * @param store the store containing payment records
     */
    public static void savePayments(Store store) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(PAYMENT_FILE)
            );

            out.writeObject(store.getPayments());
            out.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving payment records.");
        }
    }


    /**
     * Loads all payment records from file using serialization.
     *
     * @param store the store where payment records will be loaded
     */
    public static void loadPayments(Store store) {

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(PAYMENT_FILE)
            );

            ArrayList<Payment> payments = (ArrayList<Payment>) in.readObject();
            in.close();

            store.clearPayments();

            for (Payment payment : payments) {
                store.addPayment(payment);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading payment records.");
        }
    }
}