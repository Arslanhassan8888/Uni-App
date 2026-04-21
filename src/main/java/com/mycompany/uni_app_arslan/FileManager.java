package com.mycompany.uni_app_arslan;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Arslan Hassan
 */

/*
 FileManager class handles saving and loading records.

 This class is used to save data to text files
 and load data back from text files.
*/
public class FileManager {

    // File name for student records
    private static final String STUDENT_FILE = "students.txt";

    // Saves all student records to file
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

    // Loads all student records from file
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
}