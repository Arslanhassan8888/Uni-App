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
 Main class for testing the application.
 And for the University Hall system.
*/
public class Uni_App_Arslan {

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
    static JTextField studentHallField;

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
    static JPanel recordPanel;

    // EMPLOYEE FORM FIELDS
    // These will store employee input

    // Text fields for personal details
    static JTextField employeeNameField;
    static JTextField employeeDobField;
    static JTextField employeeAddressField;
    static JTextField employeeNationalityField;
    static JTextField employeeHealthField;
    static JTextField employeeRegistrationDateField;

    // Text fields for employee details
    static JTextField employeeIdField;
    static JTextField employeeJobRoleField;
    static JTextField employeeSalaryField;
    static JTextField employeeHallField;

    // Radio buttons for gender selection
    static JRadioButton employeeMaleButton;
    static JRadioButton employeeFemaleButton;
    static JRadioButton employeeOtherButton;

    // Text area for record display
    static JTextArea employeeRecordArea;

    // Scroll pane for record area
    static JScrollPane employeeRecordScrollPane;

    // Record panel
    static JPanel employeeRecordPanel;

    // Store object
    static Store store = new Store();




    /*
     MAIN METHOD
     Starts the program
    */
    public static void main(String[] args) {

        // Create main window
        JFrame frame = new JFrame("University Hall Management System");

        // Set window size
        frame.setSize(1000, 700);

        // Centre window on screen
        frame.setLocationRelativeTo(null);

        // Close program when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout
        frame.setLayout(new BorderLayout());

        // Add sections to frame
        frame.add(createHeaderPanel(), BorderLayout.NORTH);
        frame.add(createCenterPanel(), BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);

        // Make window visible
        frame.setVisible(true);
    }

    /*
     HEADER PANEL.
    */
    public static JPanel createHeaderPanel() {

        // Create panel
        JPanel headerPanel = new JPanel();

        // Create title label
        JLabel titleLabel = new JLabel("University Hall Management System");

        // Set title font
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        // Add title to panel
        headerPanel.add(titleLabel);

        return headerPanel;
    }

    /*
     CREATES CENTRE PANEL WITH TABS.
    */
    public static JPanel createCenterPanel() {

        // Main centre panel
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("Student", createStudentTab());
        tabbedPane.addTab("Employee", createEmployeeTab());
        tabbedPane.addTab("Hall", createSimpleTab("Hall Form"));
        tabbedPane.addTab("Payment", createSimpleTab("Payment Form"));

        // Add tabbed pane to centre panel
        centerPanel.add(tabbedPane, BorderLayout.CENTER);

        return centerPanel;
    }

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
        studentHallField = new JTextField(15);

        // Create options
        studentDietCombo = new JComboBox<>(new String[]{"Normal", "Vegetarian", "Vegan"});
        studentGroundFloorCheck = new JCheckBox("Required");
        studentSeniorCheck = new JCheckBox("Yes");

        // Add rows to student panel
        studentPanel.add(makeRow("Student ID:", studentIdField, labelSize));
        studentPanel.add(makeRow("Year of Study:", studentYearField, labelSize));
        studentPanel.add(makeRow("Dietary Preference:", studentDietCombo, labelSize));
        studentPanel.add(makeRow("Ground Floor:", studentGroundFloorCheck, labelSize));
        studentPanel.add(makeRow("Rent Amount:", studentRentField, labelSize));
        studentPanel.add(makeRow("Hall Name:", studentHallField, labelSize));
        studentPanel.add(makeRow("Senior Student:", studentSeniorCheck, labelSize));

        // Add both sections to form container
        formContainer.add(personalPanel);
        formContainer.add(studentPanel);

        // RECORD DISPLAY SECTION
        // This shows the saved record on the right
        recordPanel = new JPanel(new BorderLayout());
        recordPanel.setBorder(BorderFactory.createTitledBorder("Student Record Display"));

        studentRecordArea = new JTextArea(20, 30);
        studentRecordArea.setEditable(false);
        studentRecordArea.setLineWrap(true);
        studentRecordArea.setWrapStyleWord(true);

        studentRecordScrollPane = new JScrollPane(studentRecordArea);

        recordPanel.add(studentRecordScrollPane, BorderLayout.CENTER);

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(recordPanel);

        return mainPanel;
    }

    /*
 Creates EMPLOYEE TAB.
 This includes:
 personal details
 employee details
 record display area
*/
    public static JPanel createEmployeeTab() {

        // Main panel for Employee tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // FORM CONTAINER
        // This holds the form sections on the left
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(BorderFactory.createTitledBorder("Employee Form"));

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
        employeeNameField = new JTextField(15);
        namePanel.add(nameLabel);
        namePanel.add(employeeNameField);

        // Gender row
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setPreferredSize(labelSize);
        genderPanel.add(genderLabel);

        employeeMaleButton = new JRadioButton("Male");
        employeeFemaleButton = new JRadioButton("Female");
        employeeOtherButton = new JRadioButton("Other");

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(employeeMaleButton);
        genderGroup.add(employeeFemaleButton);
        genderGroup.add(employeeOtherButton);

        genderPanel.add(employeeMaleButton);
        genderPanel.add(employeeFemaleButton);
        genderPanel.add(employeeOtherButton);

        // Date of Birth row
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setPreferredSize(labelSize);
        employeeDobField = new JTextField(15);
        dobPanel.add(dobLabel);
        dobPanel.add(employeeDobField);

        // Address row
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setPreferredSize(labelSize);
        employeeAddressField = new JTextField(15);
        addressPanel.add(addressLabel);
        addressPanel.add(employeeAddressField);

        // Nationality row
        JPanel nationalityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setPreferredSize(labelSize);
        employeeNationalityField = new JTextField(15);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(employeeNationalityField);

        // Health Conditions row
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel healthLabel = new JLabel("Health Conditions:");
        healthLabel.setPreferredSize(labelSize);
        employeeHealthField = new JTextField(15);
        healthPanel.add(healthLabel);
        healthPanel.add(employeeHealthField);

        // Registration Date row
        JPanel registrationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel registrationLabel = new JLabel("Registration Date:");
        registrationLabel.setPreferredSize(labelSize);
        employeeRegistrationDateField = new JTextField(15);
        registrationPanel.add(registrationLabel);
        registrationPanel.add(employeeRegistrationDateField);

        // Add all rows to personal panel
        personalPanel.add(namePanel);
        personalPanel.add(genderPanel);
        personalPanel.add(dobPanel);
        personalPanel.add(addressPanel);
        personalPanel.add(nationalityPanel);
        personalPanel.add(healthPanel);
        personalPanel.add(registrationPanel);

        // EMPLOYEE DETAILS SECTION
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        // Create fields
        employeeIdField = new JTextField(15);
        employeeJobRoleField = new JTextField(15);
        employeeSalaryField = new JTextField(15);
        employeeHallField = new JTextField(15);

        // Add rows to employee panel
        employeePanel.add(makeRow("Employee ID:", employeeIdField, labelSize));
        employeePanel.add(makeRow("Job Role:", employeeJobRoleField, labelSize));
        employeePanel.add(makeRow("Salary:", employeeSalaryField, labelSize));
        employeePanel.add(makeRow("Hall Name:", employeeHallField, labelSize));

        // Add both sections to form container
        formContainer.add(personalPanel);
        formContainer.add(employeePanel);

        // RECORD DISPLAY SECTION
        // This shows the saved record on the right
        employeeRecordPanel = new JPanel(new BorderLayout());
        employeeRecordPanel.setBorder(BorderFactory.createTitledBorder("Employee Record Display"));

        employeeRecordArea = new JTextArea(20, 30);
        employeeRecordArea.setEditable(false);
        employeeRecordArea.setLineWrap(true);
        employeeRecordArea.setWrapStyleWord(true);

        employeeRecordScrollPane = new JScrollPane(employeeRecordArea);

        employeeRecordPanel.add(employeeRecordScrollPane, BorderLayout.CENTER);

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(employeeRecordPanel);

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
     Creates a simple placeholder tab.
    */
    public static JPanel createSimpleTab(String title) {

        // Create panel
        JPanel panel = new JPanel();

        // Add border title
        panel.setBorder(BorderFactory.createTitledBorder(title));

        // Add placeholder label
        panel.add(new JLabel("This section will be completed later."));

        return panel;
    }

    /*
     Creates the button panel.
     This includes:
     Save Record
     Next Record
     Clear Form
     Save To File
     Load From File
    */
    public static JPanel createButtonPanel() {

        // Create panel
        JPanel panel = new JPanel();

        // Create buttons
        JButton save = new JButton("Save Record");
        JButton next = new JButton("Next Record");
        JButton clear = new JButton("Clear Form");
        JButton saveFile = new JButton("Save To File");
        JButton loadFile = new JButton("Load From File");

        // Save student record
        save.addActionListener(e -> saveStudentRecord());

        // Show next student record
        next.addActionListener(e -> showNextStudentRecord());

        // Clear form
        clear.addActionListener(e -> clearStudentForm());

        // Save to file
        saveFile.addActionListener(e -> JOptionPane.showMessageDialog(null, "Save to file not implemented."));

        // Load from file
        loadFile.addActionListener(e -> JOptionPane.showMessageDialog(null, "Load from file not implemented."));

        // Add buttons to panel
        panel.add(save);
        panel.add(next);
        panel.add(clear);
        panel.add(saveFile);
        panel.add(loadFile);

        return panel;
    }

    /*
     Saves Student record into Store.
    */
    public static void saveStudentRecord() {

        try {
            String gender = "";

            if (studentMaleButton.isSelected()) {
                gender = "Male";
            } else if (studentFemaleButton.isSelected()) {
                gender = "Female";
            } else if (studentOtherButton.isSelected()) {
                gender = "Other";
            }

            Student student = new Student(
                    studentNameField.getText(),
                    gender,
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
                    studentHallField.getText(),
                    studentSeniorCheck.isSelected()
            );

            store.addStudent(student);
            JOptionPane.showMessageDialog(null, "Record Saved Successfully.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please fill all the required field.");
        }
    }
    /*
 Saves Employee record into Store.
*/
    public static void saveEmployeeRecord() {

        try {
            String gender = "";

            if (employeeMaleButton.isSelected()) {
                gender = "Male";
            } else if (employeeFemaleButton.isSelected()) {
                gender = "Female";
            } else if (employeeOtherButton.isSelected()) {
                gender = "Other";
            }

            Employee employee = new Employee(
                    employeeNameField.getText(),
                    gender,
                    employeeDobField.getText(),
                    employeeAddressField.getText(),
                    employeeNationalityField.getText(),
                    employeeHealthField.getText(),
                    employeeRegistrationDateField.getText(),
                    employeeIdField.getText(),
                    employeeJobRoleField.getText(),
                    Double.parseDouble(employeeSalaryField.getText()),
                    employeeHallField.getText()
            );

            store.addEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee record saved.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid employee data.");
        }
    }

    /*
     Shows next Student record from Store.
    */
    public static void showNextStudentRecord() {

        Student s = store.getNextStudent();

        if (s == null) {
            JOptionPane.showMessageDialog(null, "No records saved.");
            return;
        }

        // Show green background only when Next Record is clicked
        Color lightGreen = new Color(230, 250, 230);
        studentRecordArea.setBackground(lightGreen);
        studentRecordScrollPane.getViewport().setBackground(lightGreen);
        recordPanel.setBackground(lightGreen);

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
        studentRentField.setText(String.valueOf(s.getRentAmount()));
        studentHallField.setText(s.getHallName());
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
        studentHallField.setText("");

        studentMaleButton.setSelected(false);
        studentFemaleButton.setSelected(false);
        studentOtherButton.setSelected(false);

        studentDietCombo.setSelectedIndex(0);
        studentGroundFloorCheck.setSelected(false);
        studentSeniorCheck.setSelected(false);

        studentRecordArea.setText("");

        // Reset background when form is cleared
        studentRecordArea.setBackground(Color.WHITE);
        studentRecordScrollPane.getViewport().setBackground(Color.WHITE);
        recordPanel.setBackground(null);
    }
}