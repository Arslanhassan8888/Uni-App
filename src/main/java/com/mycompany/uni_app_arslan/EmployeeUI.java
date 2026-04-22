package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    static JSpinner employeeDobSpinner;
    static JTextField employeeAddressField;
    static JTextField employeeNationalityField;
    static JTextField employeeHealthField;
    static JSpinner employeeRegistrationDateSpinner;

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

    // EMPLOYEE ERROR LABELS
    // These show inline validation messages

    static JLabel employeeNameError;
    static JLabel employeeGenderError;
    static JLabel employeeDobError;
    static JLabel employeeAddressError;
    static JLabel employeeNationalityError;
    static JLabel employeeHealthError;
    static JLabel employeeRegistrationError;
    static JLabel employeeIdError;
    static JLabel employeeSalaryError;

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

        // Create error labels
        employeeNameError = createErrorLabel();
        employeeGenderError = createErrorLabel();
        employeeDobError = createErrorLabel();
        employeeAddressError = createErrorLabel();
        employeeNationalityError = createErrorLabel();
        employeeHealthError = createErrorLabel();
        employeeRegistrationError = createErrorLabel();
        employeeIdError = createErrorLabel();
        employeeSalaryError = createErrorLabel();

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setPreferredSize(labelSize);
        employeeNameField = new JTextField(15);
        namePanel.add(nameLabel);
        namePanel.add(employeeNameField);

        // Gender row
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
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
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setPreferredSize(labelSize);
        employeeDobSpinner = createDateSpinner();
        dobPanel.add(dobLabel);
        dobPanel.add(employeeDobSpinner);

        // Address row
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setPreferredSize(labelSize);
        employeeAddressField = new JTextField(15);
        addressPanel.add(addressLabel);
        addressPanel.add(employeeAddressField);

        // Nationality row
        JPanel nationalityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setPreferredSize(labelSize);
        employeeNationalityField = new JTextField(15);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(employeeNationalityField);

        // Health Conditions row
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel healthLabel = new JLabel("Health Conditions:");
        healthLabel.setPreferredSize(labelSize);
        employeeHealthField = new JTextField(15);
        healthPanel.add(healthLabel);
        healthPanel.add(employeeHealthField);

        // Registration Date row
        JPanel registrationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel registrationLabel = new JLabel("Registration Date:");
        registrationLabel.setPreferredSize(labelSize);
        employeeRegistrationDateSpinner = createDateSpinner();
        registrationPanel.add(registrationLabel);
        registrationPanel.add(employeeRegistrationDateSpinner);

        // Add all rows to personal panel
        personalPanel.add(makeFieldBlock(namePanel, employeeNameError));
        personalPanel.add(makeFieldBlock(genderPanel, employeeGenderError));
        personalPanel.add(makeFieldBlock(dobPanel, employeeDobError));
        personalPanel.add(makeFieldBlock(addressPanel, employeeAddressError));
        personalPanel.add(makeFieldBlock(nationalityPanel, employeeNationalityError));
        personalPanel.add(makeFieldBlock(healthPanel, employeeHealthError));
        personalPanel.add(makeFieldBlock(registrationPanel, employeeRegistrationError));

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
        employeePanel.add(makeFieldBlock(makeRow("Employee ID:", employeeIdField, labelSize), employeeIdError));
        employeePanel.add(makeFieldBlock(makeRow("Job Role:", employeeJobRoleCombo, labelSize), createErrorLabel()));
        employeePanel.add(makeFieldBlock(makeRow("Salary:", employeeSalaryField, labelSize), employeeSalaryError));
        employeePanel.add(makeFieldBlock(makeRow("Hall Name:", employeeHallCombo, labelSize), createErrorLabel()));

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

        // Put form container inside scroll pane
        JScrollPane formScrollPane = new JScrollPane(formContainer);
        formScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        formScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add form and record display to main panel
        mainPanel.add(formScrollPane);
        mainPanel.add(employeeRecordPanel);

        return mainPanel;
    }

    /*
     Creates a simple helper row.
    */
    public static JPanel makeRow(String labelText, java.awt.Component field, Dimension size) {

        // Create row panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));

        // Create label
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(size);

        // Add label and field
        panel.add(label);
        panel.add(field);

        return panel;
    }

    /*
     Creates a field block.
     This puts the error label under the row.
    */
    public static JPanel makeFieldBlock(JPanel rowPanel, JLabel errorLabel) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        errorLabel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        rowPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        panel.add(rowPanel);
        panel.add(errorLabel);

        return panel;
    }

    /*
     Creates an error label.
    */
    public static JLabel createErrorLabel() {

        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        return label;
    }

    /*
     Creates a simple date spinner.
    */
    public static JSpinner createDateSpinner() {

        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);

        return spinner;
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
     Gets date text from spinner.
    */
    public static String getDateText(JSpinner spinner) {

        Date date = (Date) spinner.getValue();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    /*
     Sets spinner date from text.
    */
    public static void setDateText(JSpinner spinner, String text) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(text);
            spinner.setValue(date);
        } catch (Exception ex) {
            spinner.setValue(new Date());
        }
    }

    /*
     Clears all Employee error labels.
    */
    public static void clearEmployeeErrors() {

        employeeNameError.setText(" ");
        employeeGenderError.setText(" ");
        employeeDobError.setText(" ");
        employeeAddressError.setText(" ");
        employeeNationalityError.setText(" ");
        employeeHealthError.setText(" ");
        employeeRegistrationError.setText(" ");
        employeeIdError.setText(" ");
        employeeSalaryError.setText(" ");
    }

    /*
     Validates Employee form.
    */
    public static boolean validateEmployeeForm() {

        boolean valid = true;

        clearEmployeeErrors();

        if (employeeNameField.getText().trim().isEmpty()) {
            employeeNameError.setText("Name is required.");
            valid = false;
        }

        if (getEmployeeGender().isEmpty()) {
            employeeGenderError.setText("Please select gender.");
            valid = false;
        }

        if (employeeAddressField.getText().trim().isEmpty()) {
            employeeAddressError.setText("Address is required.");
            valid = false;
        }

        if (employeeNationalityField.getText().trim().isEmpty()) {
            employeeNationalityError.setText("Nationality is required.");
            valid = false;
        }

        if (employeeHealthField.getText().trim().isEmpty()) {
            employeeHealthError.setText("Health conditions are required.");
            valid = false;
        }

        if (employeeIdField.getText().trim().isEmpty()) {
            employeeIdError.setText("Employee ID is required.");
            valid = false;
        } else if (!employeeIdField.getText().trim().matches("\\d+")) {
            employeeIdError.setText("Employee ID must be positive numbers only.");
            valid = false;
        }

        if (employeeSalaryField.getText().trim().isEmpty()) {
            employeeSalaryError.setText("Salary is required.");
            valid = false;
        } else {
            try {
                double salary = Double.parseDouble(employeeSalaryField.getText().trim());

                if (salary < 0) {
                    employeeSalaryError.setText("Salary must not be negative.");
                    valid = false;
                }

            } catch (Exception ex) {
                employeeSalaryError.setText("Salary must be a valid number.");
                valid = false;
            }
        }

        return valid;
    }

    /*
     Saves Employee record into Store.
    */
    public static void saveEmployeeRecord() {

        if (!validateEmployeeForm()) {
            JOptionPane.showMessageDialog(null, "Please correct the highlighted fields.");
            return;
        }

        try {
            Employee employee = new Employee(
                    employeeNameField.getText().trim(),
                    getEmployeeGender(),
                    getDateText(employeeDobSpinner),
                    employeeAddressField.getText().trim(),
                    employeeNationalityField.getText().trim(),
                    employeeHealthField.getText().trim(),
                    getDateText(employeeRegistrationDateSpinner),
                    employeeIdField.getText().trim(),
                    (String) employeeJobRoleCombo.getSelectedItem(),
                    Double.parseDouble(employeeSalaryField.getText().trim()),
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

        // Clear old errors
        clearEmployeeErrors();

        // Show personal details in form
        employeeNameField.setText(e.getName());
        setDateText(employeeDobSpinner, e.getDateOfBirth());
        employeeAddressField.setText(e.getAddress());
        employeeNationalityField.setText(e.getNationality());
        employeeHealthField.setText(e.getHealthConditions());
        setDateText(employeeRegistrationDateSpinner, e.getRegistrationDate());

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
        employeeSalaryField.setText(String.format("%.2f", e.getSalary()));
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
                        formatLine("Salary:", formatPounds(e.getSalary())) +
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
     Formats amount as British pounds.
    */
    public static String formatPounds(double amount) {
        return String.format("£%.2f", amount);
    }

    /*
     Clears Employee form fields.
    */
    public static void clearEmployeeForm() {

        employeeNameField.setText("");
        employeeAddressField.setText("");
        employeeNationalityField.setText("");
        employeeHealthField.setText("");

        employeeIdField.setText("");
        employeeSalaryField.setText("");

        employeeMaleButton.setSelected(false);
        employeeFemaleButton.setSelected(false);
        employeeOtherButton.setSelected(false);

        employeeJobRoleCombo.setSelectedIndex(0);
        employeeHallCombo.setSelectedIndex(0);

        employeeDobSpinner.setValue(new Date());
        employeeRegistrationDateSpinner.setValue(new Date());

        employeeRecordArea.setText("");

        clearEmployeeErrors();

        // Reset background when form is cleared
        employeeRecordArea.setBackground(Color.WHITE);
        employeeRecordScrollPane.getViewport().setBackground(Color.WHITE);
        employeeRecordPanel.setBackground(null);
    }
}