package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Arslan Hassan
 */

/*
 Student user interface.
 This class handles:
 Student form
 Student record display
 Save record
 Next record
 Clear form
*/
public class StudentUI {

    // STUDENT FORM FIELDS
    // These will store user input

    // Text fields for personal details
    static JTextField studentNameField;
    static JTextField studentDobField;
    static JTextField studentAddressField;
    static JTextField studentNationalityField;
    static JTextField studentHealthField;
    static JTextField studentRegistrationDateField;

    // Text fields for student details
    static JTextField studentIdField;
    static JTextField studentYearField;
    static JTextField studentRentField;

    // Combo box for hall selection
    static JComboBox<String> studentHallCombo;

    // Radio buttons for gender selection
    static JRadioButton studentMaleButton;
    static JRadioButton studentFemaleButton;
    static JRadioButton studentOtherButton;

    // Combo box for diet
    static JComboBox<String> studentDietCombo;

    // Check boxes for student options
    static JCheckBox studentGroundFloorCheck;
    static JCheckBox studentSeniorCheck;

    // Text area for record display
    static JTextArea studentRecordArea;

    // Scroll pane for record area
    static JScrollPane studentRecordScrollPane;

    // Record panel
    static JPanel studentRecordPanel;

    /*
     Creates STUDENT TAB.
     This includes:
     personal details
     student details
     record display area
    */
    public static JPanel createStudentTab() {

        // Main panel for Student tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // FORM CONTAINER
        // This holds the form sections on the left
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(BorderFactory.createTitledBorder("Student Form"));

        // PERSONAL DETAILS SECTION
        JPanel personalPanel = new JPanel();
        personalPanel.setLayout(new BoxLayout(personalPanel, BoxLayout.Y_AXIS));
        personalPanel.setBorder(BorderFactory.createTitledBorder("Personal Details"));

        // Common label size
        Dimension labelSize = new Dimension(140, 25);

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setPreferredSize(labelSize);
        studentNameField = new JTextField(15);
        namePanel.add(nameLabel);
        namePanel.add(studentNameField);

        // Gender row
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setPreferredSize(labelSize);
        genderPanel.add(genderLabel);

        studentMaleButton = new JRadioButton("Male");
        studentFemaleButton = new JRadioButton("Female");
        studentOtherButton = new JRadioButton("Other");

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(studentMaleButton);
        genderGroup.add(studentFemaleButton);
        genderGroup.add(studentOtherButton);

        genderPanel.add(studentMaleButton);
        genderPanel.add(studentFemaleButton);
        genderPanel.add(studentOtherButton);

        // Date of Birth row
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setPreferredSize(labelSize);
        studentDobField = new JTextField(15);
        dobPanel.add(dobLabel);
        dobPanel.add(studentDobField);

        // Address row
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setPreferredSize(labelSize);
        studentAddressField = new JTextField(15);
        addressPanel.add(addressLabel);
        addressPanel.add(studentAddressField);

        // Nationality row
        JPanel nationalityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setPreferredSize(labelSize);
        studentNationalityField = new JTextField(15);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(studentNationalityField);

        // Health Conditions row
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel healthLabel = new JLabel("Health Conditions:");
        healthLabel.setPreferredSize(labelSize);
        studentHealthField = new JTextField(15);
        healthPanel.add(healthLabel);
        healthPanel.add(studentHealthField);

        // Registration Date row
        JPanel registrationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel registrationLabel = new JLabel("Registration Date:");
        registrationLabel.setPreferredSize(labelSize);
        studentRegistrationDateField = new JTextField(15);
        registrationPanel.add(registrationLabel);
        registrationPanel.add(studentRegistrationDateField);

        // Add all rows to personal panel
        personalPanel.add(namePanel);
        personalPanel.add(genderPanel);
        personalPanel.add(dobPanel);
        personalPanel.add(addressPanel);
        personalPanel.add(nationalityPanel);
        personalPanel.add(healthPanel);
        personalPanel.add(registrationPanel);

        // STUDENT DETAILS SECTION
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        // Create fields
        studentIdField = new JTextField(15);
        studentYearField = new JTextField(15);
        studentRentField = new JTextField(15);

        // Create options
        studentDietCombo = new JComboBox<>(new String[]{"Normal", "Vegetarian", "Vegan"});
        studentHallCombo = new JComboBox<>(Uni_App_Arslan.HALL_OPTIONS);
        studentGroundFloorCheck = new JCheckBox("Required");
        studentSeniorCheck = new JCheckBox("Yes");

        // If ground floor is required
        // force the hall choice to Ground Floor Hall
        // and disable manual selection
        studentGroundFloorCheck.addActionListener(e -> {

            if (studentGroundFloorCheck.isSelected()) {
                studentHallCombo.setSelectedItem("Ground Floor Hall");
                studentHallCombo.setEnabled(false);
            } else {
                studentHallCombo.setEnabled(true);
            }
        });

        // Add rows to student panel
        studentPanel.add(makeRow("Student ID:", studentIdField, labelSize));
        studentPanel.add(makeRow("Year of Study:", studentYearField, labelSize));
        studentPanel.add(makeRow("Dietary Preference:", studentDietCombo, labelSize));
        studentPanel.add(makeRow("Ground Floor:", studentGroundFloorCheck, labelSize));
        studentPanel.add(makeRow("Rent Amount:", studentRentField, labelSize));
        studentPanel.add(makeRow("Hall Name:", studentHallCombo, labelSize));
        studentPanel.add(makeRow("Senior Student:", studentSeniorCheck, labelSize));

        // Add both sections to form container
        formContainer.add(personalPanel);
        formContainer.add(studentPanel);

        // RECORD DISPLAY SECTION
        // This shows the saved record on the right
        studentRecordPanel = new JPanel(new BorderLayout());
        studentRecordPanel.setBorder(BorderFactory.createTitledBorder("Student Record Display"));

        studentRecordArea = new JTextArea(20, 30);
        studentRecordArea.setEditable(false);
        studentRecordArea.setLineWrap(true);
        studentRecordArea.setWrapStyleWord(true);

        studentRecordScrollPane = new JScrollPane(studentRecordArea);

        studentRecordPanel.add(studentRecordScrollPane, BorderLayout.CENTER);

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(studentRecordPanel);

        return mainPanel;
    }

    /*
     Creates a simple helper row.
    */
    public static JPanel makeRow(String labelText, java.awt.Component field, Dimension size) {

        // Create row panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));

        // Create label
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(size);

        // Add label and field
        panel.add(label);
        panel.add(field);

        return panel;
    }

    /*
     Gets selected gender from Student radio buttons.
    */
    public static String getStudentGender() {

        if (studentMaleButton.isSelected()) {
            return "Male";
        } else if (studentFemaleButton.isSelected()) {
            return "Female";
        } else if (studentOtherButton.isSelected()) {
            return "Other";
        }

        return "";
    }

    /*
     Saves Student record into Store.
    */
    public static void saveStudentRecord() {

        try {
            Student student = new Student(
                    studentNameField.getText(),
                    getStudentGender(),
                    studentDobField.getText(),
                    studentAddressField.getText(),
                    studentNationalityField.getText(),
                    studentHealthField.getText(),
                    studentRegistrationDateField.getText(),
                    studentIdField.getText(),
                    Integer.parseInt(studentYearField.getText()),
                    (String) studentDietCombo.getSelectedItem(),
                    studentGroundFloorCheck.isSelected(),
                    Double.parseDouble(studentRentField.getText()),
                    (String) studentHallCombo.getSelectedItem(),
                    studentSeniorCheck.isSelected()
            );

            Uni_App_Arslan.store.addStudent(student);
            JOptionPane.showMessageDialog(null, "Student record saved.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
        }
    }

    /*
     Shows next Student record from Store.
    */
    public static void showNextStudentRecord() {

        Student s = Uni_App_Arslan.store.getNextStudent();

        if (s == null) {
            JOptionPane.showMessageDialog(null, "No student records saved.");
            return;
        }

        // Show green background only when Next Record is clicked
        Color lightGreen = new Color(230, 250, 230);
        studentRecordArea.setBackground(lightGreen);
        studentRecordScrollPane.getViewport().setBackground(lightGreen);
        studentRecordPanel.setBackground(lightGreen);

        // Show personal details in form
        studentNameField.setText(s.getName());
        studentDobField.setText(s.getDateOfBirth());
        studentAddressField.setText(s.getAddress());
        studentNationalityField.setText(s.getNationality());
        studentHealthField.setText(s.getHealthConditions());
        studentRegistrationDateField.setText(s.getRegistrationDate());

        // Show gender
        if (s.getGender().equals("Male")) {
            studentMaleButton.setSelected(true);
        } else if (s.getGender().equals("Female")) {
            studentFemaleButton.setSelected(true);
        } else {
            studentOtherButton.setSelected(true);
        }

        // Show student details in form
        studentIdField.setText(s.getStudentId());
        studentYearField.setText(String.valueOf(s.getYearOfStudy()));
        studentDietCombo.setSelectedItem(s.getDietaryPreference());
        studentGroundFloorCheck.setSelected(s.isGroundFloorRequired());

        if (s.isGroundFloorRequired()) {
            studentHallCombo.setSelectedItem("Ground Floor Hall");
            studentHallCombo.setEnabled(false);
        } else {
            studentHallCombo.setEnabled(true);
            studentHallCombo.setSelectedItem(s.getHallName());
        }

        studentRentField.setText(String.valueOf(s.getRentAmount()));
        studentSeniorCheck.setSelected(s.isSeniorStudent());

        // Show record in display area
        studentRecordArea.setText(
                "STUDENT RECORD\n\n" +
                        formatLine("Name:", s.getName()) +
                        formatLine("Gender:", s.getGender()) +
                        formatLine("Date of Birth:", s.getDateOfBirth()) +
                        formatLine("Address:", s.getAddress()) +
                        formatLine("Nationality:", s.getNationality()) +
                        formatLine("Health Conditions:", s.getHealthConditions()) +
                        formatLine("Registration Date:", s.getRegistrationDate()) +
                        formatLine("Student ID:", s.getStudentId()) +
                        formatLine("Year of Study:", String.valueOf(s.getYearOfStudy())) +
                        formatLine("Dietary Preference:", s.getDietaryPreference()) +
                        formatLine("Ground Floor Required:", yesNo(s.isGroundFloorRequired())) +
                        formatLine("Rent Amount:", String.valueOf(s.getRentAmount())) +
                        formatLine("Hall Name:", s.getHallName()) +
                        formatLine("Senior Student:", yesNo(s.isSeniorStudent()))
        );
    }

    /*
     Formats one display line.
    */
    public static String formatLine(String label, String value) {

        if (value == null || value.trim().isEmpty()) {
            value = "NA";
        }

        return label + " " + value + "\n\n";
    }

    /*
     Converts boolean to Yes or No.
    */
    public static String yesNo(boolean value) {

        if (value) {
            return "Yes";
        }

        return "No";
    }

    /*
     Clears Student form fields.
    */
    public static void clearStudentForm() {

        studentNameField.setText("");
        studentDobField.setText("");
        studentAddressField.setText("");
        studentNationalityField.setText("");
        studentHealthField.setText("");
        studentRegistrationDateField.setText("");

        studentIdField.setText("");
        studentYearField.setText("");
        studentRentField.setText("");

        studentMaleButton.setSelected(false);
        studentFemaleButton.setSelected(false);
        studentOtherButton.setSelected(false);

        studentDietCombo.setSelectedIndex(0);
        studentGroundFloorCheck.setSelected(false);
        studentHallCombo.setEnabled(true);
        studentHallCombo.setSelectedIndex(0);
        studentSeniorCheck.setSelected(false);

        studentRecordArea.setText("");

        // Reset background when form is cleared
        studentRecordArea.setBackground(Color.WHITE);
        studentRecordScrollPane.getViewport().setBackground(Color.WHITE);
        studentRecordPanel.setBackground(null);
    }
}