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
 Employee user interface.
 This class handles:
 Employee form
 Employee record display
 Save record
 Next record
 Clear form
*/
public class EmployeeUI {

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
    static JTextField employeeSalaryField;

    // Combo boxes for employee details
    static JComboBox<String> employeeJobRoleCombo;
    static JComboBox<String> employeeHallCombo;

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
        employeeSalaryField = new JTextField(15);

        // Create combo boxes
        employeeJobRoleCombo = new JComboBox<>(Uni_App_Arslan.JOB_ROLE_OPTIONS);
        employeeHallCombo = new JComboBox<>(Uni_App_Arslan.HALL_OPTIONS);

        // Add rows to employee panel
        employeePanel.add(makeRow("Employee ID:", employeeIdField, labelSize));
        employeePanel.add(makeRow("Job Role:", employeeJobRoleCombo, labelSize));
        employeePanel.add(makeRow("Salary:", employeeSalaryField, labelSize));
        employeePanel.add(makeRow("Hall Name:", employeeHallCombo, labelSize));

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
     Gets selected gender from Employee radio buttons.
    */
    public static String getEmployeeGender() {

        if (employeeMaleButton.isSelected()) {
            return "Male";
        } else if (employeeFemaleButton.isSelected()) {
            return "Female";
        } else if (employeeOtherButton.isSelected()) {
            return "Other";
        }

        return "";
    }

    /*
     Saves Employee record into Store.
    */
    public static void saveEmployeeRecord() {

        try {
            Employee employee = new Employee(
                    employeeNameField.getText(),
                    getEmployeeGender(),
                    employeeDobField.getText(),
                    employeeAddressField.getText(),
                    employeeNationalityField.getText(),
                    employeeHealthField.getText(),
                    employeeRegistrationDateField.getText(),
                    employeeIdField.getText(),
                    (String) employeeJobRoleCombo.getSelectedItem(),
                    Double.parseDouble(employeeSalaryField.getText()),
                    (String) employeeHallCombo.getSelectedItem()
            );

            Uni_App_Arslan.store.addEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee record saved.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please fill employee data.");
        }
    }

    /*
     Shows next Employee record from Store.
    */
    public static void showNextEmployeeRecord() {

        Employee e = Uni_App_Arslan.store.getNextEmployee();

        if (e == null) {
            JOptionPane.showMessageDialog(null, "No employee records saved.");
            return;
        }

        // Show light blue background only when Next Record is clicked
        Color lightBlue = new Color(230, 240, 255);
        employeeRecordArea.setBackground(lightBlue);
        employeeRecordScrollPane.getViewport().setBackground(lightBlue);
        employeeRecordPanel.setBackground(lightBlue);

        // Show personal details in form
        employeeNameField.setText(e.getName());
        employeeDobField.setText(e.getDateOfBirth());
        employeeAddressField.setText(e.getAddress());
        employeeNationalityField.setText(e.getNationality());
        employeeHealthField.setText(e.getHealthConditions());
        employeeRegistrationDateField.setText(e.getRegistrationDate());

        // Show gender
        if (e.getGender().equals("Male")) {
            employeeMaleButton.setSelected(true);
        } else if (e.getGender().equals("Female")) {
            employeeFemaleButton.setSelected(true);
        } else {
            employeeOtherButton.setSelected(true);
        }

        // Show employee details in form
        employeeIdField.setText(e.getEmployeeId());
        employeeJobRoleCombo.setSelectedItem(e.getJobRole());
        employeeSalaryField.setText(String.valueOf(e.getSalary()));
        employeeHallCombo.setSelectedItem(e.getHallName());

        // Show record in display area
        employeeRecordArea.setText(
                "EMPLOYEE RECORD\n\n" +
                        formatLine("Name:", e.getName()) +
                        formatLine("Gender:", e.getGender()) +
                        formatLine("Date of Birth:", e.getDateOfBirth()) +
                        formatLine("Address:", e.getAddress()) +
                        formatLine("Nationality:", e.getNationality()) +
                        formatLine("Health Conditions:", e.getHealthConditions()) +
                        formatLine("Registration Date:", e.getRegistrationDate()) +
                        formatLine("Employee ID:", e.getEmployeeId()) +
                        formatLine("Job Role:", e.getJobRole()) +
                        formatLine("Salary:", String.valueOf(e.getSalary())) +
                        formatLine("Hall Name:", e.getHallName())
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
     Clears Employee form fields.
    */
    public static void clearEmployeeForm() {

        employeeNameField.setText("");
        employeeDobField.setText("");
        employeeAddressField.setText("");
        employeeNationalityField.setText("");
        employeeHealthField.setText("");
        employeeRegistrationDateField.setText("");

        employeeIdField.setText("");
        employeeSalaryField.setText("");

        employeeMaleButton.setSelected(false);
        employeeFemaleButton.setSelected(false);
        employeeOtherButton.setSelected(false);

        employeeJobRoleCombo.setSelectedIndex(0);
        employeeHallCombo.setSelectedIndex(0);

        employeeRecordArea.setText("");

        // Reset background when form is cleared
        employeeRecordArea.setBackground(Color.WHITE);
        employeeRecordScrollPane.getViewport().setBackground(Color.WHITE);
        employeeRecordPanel.setBackground(null);
    }
}