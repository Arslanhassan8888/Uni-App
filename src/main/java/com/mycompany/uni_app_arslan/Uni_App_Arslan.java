package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

    // Radio buttons for gender selection
    static JRadioButton studentMaleButton;
    static JRadioButton studentFemaleButton;
    static JRadioButton studentOtherButton;

    // MAIN METHOD
    // Starts the program
    public static void main(String[] args) {

        // Create main window
        JFrame frame = new JFrame("University Hall Management System");

        // Set window size
        frame.setSize(800, 700);

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
     Creates the header panel.
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
     Creates the centre panel with tabs.
    */
    public static JPanel createCenterPanel() {

        // Main centre panel
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("Student", createStudentTab());
        tabbedPane.addTab("Employee", createSimpleTab("Employee Form"));
        tabbedPane.addTab("Hall", createSimpleTab("Hall Form"));
        tabbedPane.addTab("Payment", createSimpleTab("Payment Form"));

        // Add tabbed pane to centre panel
        centerPanel.add(tabbedPane, BorderLayout.CENTER);

        return centerPanel;
    }

    /*
     Creates the Student tab.
     This includes:
     personal details
     student details
    */
    public static JPanel createStudentTab() {

        // Main panel for Student tab
        JPanel mainPanel = new JPanel();

        // Use vertical layout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // PERSONAL DETAILS SECTION
        
        JPanel personalPanel = new JPanel();

        // Vertical layout for rows
        personalPanel.setLayout(new BoxLayout(personalPanel, BoxLayout.Y_AXIS));

        // Add border title
        personalPanel.setBorder(BorderFactory.createTitledBorder("Personal Details"));

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(new JLabel("Name:"));
        studentNameField = new JTextField(15);
        namePanel.add(studentNameField);

        // Gender row
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        genderPanel.add(new JLabel("Gender:"));

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
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dobPanel.add(new JLabel("Date of Birth:"));
        studentDobField = new JTextField(15);
        dobPanel.add(studentDobField);

        // Address row
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addressPanel.add(new JLabel("Address:"));
        studentAddressField = new JTextField(15);
        addressPanel.add(studentAddressField);

        // Nationality row
        JPanel nationalityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nationalityPanel.add(new JLabel("Nationality:"));
        studentNationalityField = new JTextField(15);
        nationalityPanel.add(studentNationalityField);

        // Health Conditions row
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        healthPanel.add(new JLabel("Health Conditions:"));
        studentHealthField = new JTextField(15);
        healthPanel.add(studentHealthField);

        // Registration Date row
        JPanel registrationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registrationPanel.add(new JLabel("Registration Date:"));
        studentRegistrationDateField = new JTextField(15);
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

        // Vertical layout for rows
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));

        // Add border title
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        // Student ID row
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField(15);
        idPanel.add(studentIdField);

        // Year of Study row
        JPanel yearPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        yearPanel.add(new JLabel("Year of Study:"));
        studentYearField = new JTextField(15);
        yearPanel.add(studentYearField);

        // Add rows to student panel
        studentPanel.add(idPanel);
        studentPanel.add(yearPanel);

        // Add both sections to main panel
        mainPanel.add(personalPanel);
        mainPanel.add(studentPanel);

        return mainPanel;
    }

    /*
     Creates a simple placeholder tab.
    */
    public static JPanel createSimpleTab(String title) {

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createTitledBorder(title));

        JLabel label = new JLabel("This section will be completed later.");
        panel.add(label);

        return panel;
    }

    /*
     Creates the button panel.
    */
    public static JPanel createButtonPanel() {

        JPanel buttonPanel = new JPanel();

        // Create buttons
        JButton saveButton = new JButton("Save Record");
        JButton nextButton = new JButton("Next Record");
        JButton clearButton = new JButton("Clear Form");
        JButton saveFileButton = new JButton("Save To File");
        JButton loadFileButton = new JButton("Load From File");

        // Add buttons to panel
        buttonPanel.add(saveButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveFileButton);
        buttonPanel.add(loadFileButton);

        return buttonPanel;
    }
}