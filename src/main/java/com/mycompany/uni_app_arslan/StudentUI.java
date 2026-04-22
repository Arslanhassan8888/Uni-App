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
    static JSpinner studentDobSpinner;
    static JTextField studentAddressField;
    static JTextField studentNationalityField;
    static JTextField studentHealthField;
    static JSpinner studentRegistrationDateSpinner;

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

    // STUDENT ERROR LABELS
    // These show inline validation messages

    static JLabel studentNameError;
    static JLabel studentGenderError;
    static JLabel studentDobError;
    static JLabel studentAddressError;
    static JLabel studentNationalityError;
    static JLabel studentHealthError;
    static JLabel studentRegistrationError;
    static JLabel studentIdError;
    static JLabel studentYearError;
    static JLabel studentRentError;

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

        // Create error labels
        studentNameError = createErrorLabel();
        studentGenderError = createErrorLabel();
        studentDobError = createErrorLabel();
        studentAddressError = createErrorLabel();
        studentNationalityError = createErrorLabel();
        studentHealthError = createErrorLabel();
        studentRegistrationError = createErrorLabel();
        studentIdError = createErrorLabel();
        studentYearError = createErrorLabel();
        studentRentError = createErrorLabel();

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setPreferredSize(labelSize);
        studentNameField = new JTextField(15);
        studentNameField.setToolTipText("Enter full name");
        namePanel.add(nameLabel);
        namePanel.add(studentNameField);

        // Gender row
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
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
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setPreferredSize(labelSize);
        studentDobSpinner = createDateSpinner();
        studentDobSpinner.setToolTipText("Select date of birth");
        dobPanel.add(dobLabel);
        dobPanel.add(studentDobSpinner);

        // Address row
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setPreferredSize(labelSize);
        studentAddressField = new JTextField(15);
        studentAddressField.setToolTipText("Enter address");
        addressPanel.add(addressLabel);
        addressPanel.add(studentAddressField);

        // Nationality row
        JPanel nationalityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setPreferredSize(labelSize);
        studentNationalityField = new JTextField(15);
        studentNationalityField.setToolTipText("Enter nationality");
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(studentNationalityField);

        // Health Conditions row
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel healthLabel = new JLabel("Health Conditions:");
        healthLabel.setPreferredSize(labelSize);
        studentHealthField = new JTextField(15);
        studentHealthField.setToolTipText("Enter health conditions");
        healthPanel.add(healthLabel);
        healthPanel.add(studentHealthField);

        // Registration Date row
        JPanel registrationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel registrationLabel = new JLabel("Registration Date:");
        registrationLabel.setPreferredSize(labelSize);
        studentRegistrationDateSpinner = createDateSpinner();
        studentRegistrationDateSpinner.setToolTipText("Select registration date");
        registrationPanel.add(registrationLabel);
        registrationPanel.add(studentRegistrationDateSpinner);

        // Add all rows to personal panel
        personalPanel.add(makeFieldBlock(namePanel, studentNameError));
        personalPanel.add(makeFieldBlock(genderPanel, studentGenderError));
        personalPanel.add(makeFieldBlock(dobPanel, studentDobError));
        personalPanel.add(makeFieldBlock(addressPanel, studentAddressError));
        personalPanel.add(makeFieldBlock(nationalityPanel, studentNationalityError));
        personalPanel.add(makeFieldBlock(healthPanel, studentHealthError));
        personalPanel.add(makeFieldBlock(registrationPanel, studentRegistrationError));

        // STUDENT DETAILS SECTION
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        // Create fields
        studentIdField = new JTextField(15);
        studentYearField = new JTextField(15);
        studentRentField = new JTextField(15);

        studentIdField.setToolTipText("Enter numbers only");
        studentYearField.setToolTipText("Enter 1 to 3");
        studentRentField.setToolTipText("Enter positive amount");

        // Create options
        studentDietCombo = new JComboBox<>(new String[]{"Normal", "Vegetarian", "Vegan"});
        studentDietCombo.addActionListener(e -> updateHallSelection());
        studentHallCombo = new JComboBox<>(Uni_App_Arslan.HALL_OPTIONS);
        studentGroundFloorCheck = new JCheckBox("Required");
        studentSeniorCheck = new JCheckBox("Yes");

        // If ground floor is required
        // force the hall choice to Ground Floor Hall
        // and disable manual selection
        studentGroundFloorCheck.addActionListener(e -> updateHallSelection());

        // Add rows to student panel
        studentPanel.add(makeFieldBlock(makeRow("Student ID:", studentIdField, labelSize), studentIdError));
        studentPanel.add(makeFieldBlock(makeRow("Year of Study:", studentYearField, labelSize), studentYearError));
        studentPanel.add(makeFieldBlock(makeRow("Dietary Preference:", studentDietCombo, labelSize), createErrorLabel()));
        studentPanel.add(makeFieldBlock(makeRow("Ground Floor:", studentGroundFloorCheck, labelSize), createErrorLabel()));
        studentPanel.add(makeFieldBlock(makeRow("Rent Amount:", studentRentField, labelSize), studentRentError));
        studentPanel.add(makeFieldBlock(makeRow("Hall Name:", studentHallCombo, labelSize), createErrorLabel()));
        studentPanel.add(makeFieldBlock(makeRow("Senior Student:", studentSeniorCheck, labelSize), createErrorLabel()));

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

        // Put form container inside scroll pane
        JScrollPane formScrollPane = new JScrollPane(formContainer);
        formScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        formScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add form and record display to main panel
        mainPanel.add(formScrollPane);
        mainPanel.add(studentRecordPanel);

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
 Updates hall selection based on student needs.
*/
    public static void updateHallSelection() {

        // If health condition is entered, force ground floor
        if (!studentHealthField.getText().trim().isEmpty()) {
            studentHallCombo.setSelectedItem("Ground Floor Hall");
            studentHallCombo.setEnabled(false);
            return;
        }

        // If ground floor is required, force ground floor
        if (studentGroundFloorCheck.isSelected()) {
            studentHallCombo.setSelectedItem("Ground Floor Hall");
            studentHallCombo.setEnabled(false);
            return;
        }

        // Check dietary preference
        String diet = (String) studentDietCombo.getSelectedItem();

        if (diet.equals("Vegetarian")) {
            studentHallCombo.setSelectedItem("First Floor Hall");
            studentHallCombo.setEnabled(false);
        } else if (diet.equals("Vegan")) {
            studentHallCombo.setSelectedItem("Second Floor Hall");
            studentHallCombo.setEnabled(false);
        } else {
            studentHallCombo.setEnabled(true);
        }
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
     Clears all Student error labels.
    */
    public static void clearStudentErrors() {

        studentNameError.setText(" ");
        studentGenderError.setText(" ");
        studentDobError.setText(" ");
        studentAddressError.setText(" ");
        studentNationalityError.setText(" ");
        studentHealthError.setText(" ");
        studentRegistrationError.setText(" ");
        studentIdError.setText(" ");
        studentYearError.setText(" ");
        studentRentError.setText(" ");
    }

    /*
     Validates Student form.
    */
    public static boolean validateStudentForm() {

        boolean valid = true;

        clearStudentErrors();

        if (studentNameField.getText().trim().isEmpty()) {
            studentNameError.setText("Name is required.");
            valid = false;
        }

        if (getStudentGender().isEmpty()) {
            studentGenderError.setText("Please select gender.");
            valid = false;
        }

        if (studentAddressField.getText().trim().isEmpty()) {
            studentAddressError.setText("Address is required.");
            valid = false;
        }

        if (studentNationalityField.getText().trim().isEmpty()) {
            studentNationalityError.setText("Nationality is required.");
            valid = false;
        }

        if (studentHealthField.getText().trim().isEmpty()) {
            studentHealthError.setText("Health conditions are required.");
            valid = false;
        }

        if (studentIdField.getText().trim().isEmpty()) {
            studentIdError.setText("Student ID is required.");
            valid = false;
        } else if (!studentIdField.getText().trim().matches("\\d+")) {
            studentIdError.setText("Student ID must be numbers only.");
            valid = false;
        }

        if (studentYearField.getText().trim().isEmpty()) {
            studentYearError.setText("Year of Study is required.");
            valid = false;
        } else {
            try {
                int year = Integer.parseInt(studentYearField.getText().trim());

                if (year < 1 || year > 3) {
                    studentYearError.setText("Year of Study must be 1 to 3.");
                    valid = false;
                }

            } catch (Exception ex) {
                studentYearError.setText("Year of Study must be a number.");
                valid = false;
            }
        }

        if (studentRentField.getText().trim().isEmpty()) {
            studentRentError.setText("Rent amount is required.");
            valid = false;
        } else {
            try {
                double rent = Double.parseDouble(studentRentField.getText().trim());

                if (rent <= 0) {
                    studentRentError.setText("Rent must be a positive number.");
                    valid = false;
                }

            } catch (Exception ex) {
                studentRentError.setText("Rent must be a valid number.");
                valid = false;
            }
        }

        return valid;
    }

    /*
     Saves Student record into Store.
    */
    public static void saveStudentRecord() {

        if (!validateStudentForm()) {
            JOptionPane.showMessageDialog(null, "Please correct the highlighted fields.");
            return;
        }

        try {
            Student student = new Student(
                    studentNameField.getText().trim(),
                    getStudentGender(),
                    getDateText(studentDobSpinner),
                    studentAddressField.getText().trim(),
                    studentNationalityField.getText().trim(),
                    studentHealthField.getText().trim(),
                    getDateText(studentRegistrationDateSpinner),
                    studentIdField.getText().trim(),
                    Integer.parseInt(studentYearField.getText().trim()),
                    (String) studentDietCombo.getSelectedItem(),
                    studentGroundFloorCheck.isSelected(),
                    Double.parseDouble(studentRentField.getText().trim()),
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

        // Clear old errors
        clearStudentErrors();

        // Show personal details in form
        studentNameField.setText(s.getName());
        setDateText(studentDobSpinner, s.getDateOfBirth());
        studentAddressField.setText(s.getAddress());
        studentNationalityField.setText(s.getNationality());
        studentHealthField.setText(s.getHealthConditions());
        setDateText(studentRegistrationDateSpinner, s.getRegistrationDate());

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

        studentRentField.setText(String.format("%.2f", s.getRentAmount()));
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
                        formatLine("Rent Amount:", formatPounds(s.getRentAmount())) +
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
     Formats amount as British pounds.
    */
    public static String formatPounds(double amount) {
        return String.format("£%.2f", amount);
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
        studentAddressField.setText("");
        studentNationalityField.setText("");
        studentHealthField.setText("");

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

        studentDobSpinner.setValue(new Date());
        studentRegistrationDateSpinner.setValue(new Date());

        studentRecordArea.setText("");

        clearStudentErrors();

        // Reset background when form is cleared
        studentRecordArea.setBackground(Color.WHITE);
        studentRecordScrollPane.getViewport().setBackground(Color.WHITE);
        studentRecordPanel.setBackground(null);
    }
}