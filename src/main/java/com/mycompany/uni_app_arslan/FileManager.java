package com.mycompany.uni_app_arslan;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * FileManager class handles saving and loading records.
 *
 * This class is used to save data to text files
 * and load data back from text files.
 *
 * @author Arslan Hassan
 */
public class FileManager {

    /** File name for student records */
    private static final String STUDENT_FILE = "students.txt";

    /** File name for employee records */
    private static final String EMPLOYEE_FILE = "employees.txt";

    /** File name for hall records */
    private static final String HALL_FILE = "halls.txt";

    /** File name for payment records */
    private static final String PAYMENT_FILE = "payments.txt";

    /** Saves all student records to file */
    public static void saveStudents(Store store) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(STUDENT_FILE));

            // Get all student records
            ArrayList<Student> students = store.getStudents();

            // Write each student to file
            for (Student student : students) {

                writer.println(
                        student.getName() + "," +
                                student.getGender() + "," +
                                student.getDateOfBirth() + "," +
                                student.getAddress() + "," +
                                student.getNationality() + "," +
                                student.getHealthConditions() + "," +
                                student.getRegistrationDate() + "," +
                                student.getStudentId() + "," +
                                student.getYearOfStudy() + "," +
                                student.getDietaryPreference() + "," +
                                student.isGroundFloorRequired() + "," +
                                student.getRentAmount() + "," +
                                student.getHallName() + "," +
                                student.isSeniorStudent()
                );
            }

            // Close writer
            writer.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving student records.");
        }
    }

    /** Loads all student records from file */
    public static void loadStudents(Store store) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE));

            // Clear old student records before loading new ones
            store.clearStudents();

            String line;

            // Read each line from file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                Student student = new Student(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7],
                        Integer.parseInt(parts[8]),
                        parts[9],
                        Boolean.parseBoolean(parts[10]),
                        Double.parseDouble(parts[11]),
                        parts[12],
                        Boolean.parseBoolean(parts[13])
                );

                store.addStudent(student);
            }

            // Close reader
            reader.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading student records.");
        }
    }

    /** Saves all employee records to file */
    public static void saveEmployees(Store store) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(EMPLOYEE_FILE));

            // Get all employee records
            ArrayList<Employee> employees = store.getEmployees();

            // Write each employee to file
            for (Employee employee : employees) {

                writer.println(
                        employee.getName() + "," +
                                employee.getGender() + "," +
                                employee.getDateOfBirth() + "," +
                                employee.getAddress() + "," +
                                employee.getNationality() + "," +
                                employee.getHealthConditions() + "," +
                                employee.getRegistrationDate() + "," +
                                employee.getEmployeeId() + "," +
                                employee.getJobRole() + "," +
                                employee.getSalary() + "," +
                                employee.getHallName()
                );
            }

            // Close writer
            writer.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving employee records.");
        }
    }

    /** Loads all employee records from file */
    public static void loadEmployees(Store store) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE));

            // Clear old employee records before loading new ones
            store.clearEmployees();

            String line;

            // Read each line from file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                Employee employee = new Employee(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7],
                        parts[8],
                        Double.parseDouble(parts[9]),
                        parts[10]
                );

                store.addEmployee(employee);
            }

            // Close reader
            reader.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading employee records.");
        }
    }

    /** Saves all hall records to file */
    public static void saveHalls(Store store) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(HALL_FILE));

            // Get all hall records
            ArrayList<Hall> halls = store.getHalls();

            // Write each hall to file
            for (Hall hall : halls) {

                writer.println(
                        hall.getHallName() + "," +
                                hall.getHallType() + "," +
                                hall.getResidentType() + "," +
                                hall.getResidentId() + "," +
                                hall.getRoomType() + "," +
                                hall.isVegetarianFriendly() + "," +
                                hall.isVeganFriendly()
                );
            }

            // Close writer
            writer.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving hall records.");
        }
    }

    /** Loads all hall records from file */
    public static void loadHalls(Store store) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(HALL_FILE));

            // Clear old hall records before loading new ones
            store.clearHalls();

            String line;

            // Read each line from file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                Hall hall = new Hall(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        Boolean.parseBoolean(parts[5]),
                        Boolean.parseBoolean(parts[6])
                );

                store.addHall(hall);
            }

            // Close reader
            reader.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading hall records.");
        }
    }

    /** Saves all payment records to file */
    public static void savePayments(Store store) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(PAYMENT_FILE));

            // Get all payment records
            ArrayList<Payment> payments = store.getPayments();

            // Write each payment to file
            for (Payment payment : payments) {

                writer.println(
                        payment.getPaymentId() + "," +
                                payment.getStudentId() + "," +
                                payment.getStudentName() + "," +
                                payment.getAmount() + "," +
                                payment.getPaymentDate() + "," +
                                payment.getPaymentMethod() + "," +
                                payment.isPaid()
                );
            }

            // Close writer
            writer.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving payment records.");
        }
    }

    /** Loads all payment records from file */
    public static void loadPayments(Store store) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PAYMENT_FILE));

            // Clear old payment records before loading new ones
            store.clearPayments();

            String line;

            // Read each line from file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                Payment payment = new Payment(
                        parts[0],
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3]),
                        parts[4],
                        parts[5],
                        Boolean.parseBoolean(parts[6])
                );

                store.addPayment(payment);
            }

            // Close reader
            reader.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading payment records.");
        }
    }
}