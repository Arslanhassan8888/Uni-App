package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Search user interface.
 * This class handles:
 * Search form
 * Search result display
 * Search validation
 * Clear form
 *
 * @author Arslan Hassan
 */
public class SearchUI {

    /**
     * SEARCH FORM FIELDS
     * These will store search input
     */

    /** Text field for ID search */
    static JTextField searchIdField;

    /** Error label */
    static JLabel searchIdError;

    /** Text area for search result display */
    static JTextArea searchResultArea;

    /** Scroll pane for result area */
    static JScrollPane searchResultScrollPane;

    /** Record panel */
    static JPanel searchResultPanel;

    /**
     * Creates SEARCH TAB.
     * This includes:
     * search form
     * result display area
     */
    public static JPanel createSearchTab() {

        // Main panel for Search tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // FORM CONTAINER
        // This holds the form section on the left
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(BorderFactory.createTitledBorder("Search Person"));

        // SEARCH SECTION
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Details"));

        // Common label size
        Dimension labelSize = new Dimension(140, 25);

        // Create error label
        searchIdError = createErrorLabel();

        // Create field
        searchIdField = new JTextField(15);

        // Create search button
        JButton searchButton = new JButton("Search");

        // Search row
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        JLabel searchLabel = new JLabel("Person ID:");
        searchLabel.setPreferredSize(labelSize);
        searchRow.add(searchLabel);
        searchRow.add(searchIdField);
        searchRow.add(searchButton);

        // Add row to search panel
        searchPanel.add(makeFieldBlock(searchRow, searchIdError));

        // Keep search panel at top
        searchPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        formContainer.add(searchPanel);
        formContainer.add(Box.createVerticalGlue());

        // RESULT DISPLAY SECTION
        // This shows the found record on the right
        searchResultPanel = new JPanel(new BorderLayout());
        searchResultPanel.setBorder(BorderFactory.createTitledBorder("Search Result Display"));

        searchResultArea = new JTextArea(20, 30);
        searchResultArea.setEditable(false);
        searchResultArea.setLineWrap(true);
        searchResultArea.setWrapStyleWord(true);

        searchResultScrollPane = new JScrollPane(searchResultArea);

        searchResultPanel.add(searchResultScrollPane, BorderLayout.CENTER);

        // Search button action
        searchButton.addActionListener(e -> searchPerson());

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(searchResultPanel);

        return mainPanel;
    }

    /**
     * Creates a field block.
     * This puts the error label under the row.
     */
    public static JPanel makeFieldBlock(JPanel rowPanel, JLabel errorLabel) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Keep everything aligned to left
        panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        rowPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        errorLabel.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        panel.add(rowPanel);
        panel.add(errorLabel);

        return panel;
    }

    /**
     * Creates an error label.
     */
    public static JLabel createErrorLabel() {

        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        return label;
    }

    /**
     * Searches for a person by ID.
     */
    public static void searchPerson() {

        // Clear old error
        searchIdError.setText(" ");
        searchResultArea.setText("");

        // Reset result colour
        searchResultArea.setBackground(Color.WHITE);
        searchResultScrollPane.getViewport().setBackground(Color.WHITE);
        searchResultPanel.setBackground(null);

        // Get entered ID
        String id = searchIdField.getText().trim();

        // Validate input
        if (id.isEmpty()) {
            searchIdError.setText("ID is required.");
            return;
        }

        if (!id.matches("\\d+")) {
            searchIdError.setText("ID must be positive numbers only.");
            return;
        }

        // Search student first
        Student student = Uni_App_Arslan.store.findStudentById(id);

        if (student != null) {

            // Show green colour for student
            Color lightGreen = new Color(230, 250, 230);
            searchResultArea.setBackground(lightGreen);
            searchResultScrollPane.getViewport().setBackground(lightGreen);
            searchResultPanel.setBackground(lightGreen);

            searchResultArea.setText(
                    "STUDENT RECORD\n\n" +
                            formatLine("Name:", student.getName()) +
                            formatLine("Gender:", student.getGender()) +
                            formatLine("Date of Birth:", student.getDateOfBirth()) +
                            formatLine("Address:", student.getAddress()) +
                            formatLine("Nationality:", student.getNationality()) +
                            formatLine("Health Conditions:", student.getHealthConditions()) +
                            formatLine("Registration Date:", student.getRegistrationDate()) +
                            formatLine("Student ID:", student.getStudentId()) +
                            formatLine("Year of Study:", String.valueOf(student.getYearOfStudy())) +
                            formatLine("Dietary Preference:", student.getDietaryPreference()) +
                            formatLine("Ground Floor Required:", yesNo(student.isGroundFloorRequired())) +
                            formatLine("Rent Amount:", formatPounds(student.getRentAmount())) +
                            formatLine("Hall Name:", student.getHallName()) +
                            formatLine("Senior Student:", yesNo(student.isSeniorStudent()))
            );

            return;
        }

        // Search employee if student not found
        Employee employee = Uni_App_Arslan.store.findEmployeeById(id);

        if (employee != null) {

            // Show blue colour for employee
            Color lightBlue = new Color(230, 240, 255);
            searchResultArea.setBackground(lightBlue);
            searchResultScrollPane.getViewport().setBackground(lightBlue);
            searchResultPanel.setBackground(lightBlue);

            searchResultArea.setText(
                    "EMPLOYEE RECORD\n\n" +
                            formatLine("Name:", employee.getName()) +
                            formatLine("Gender:", employee.getGender()) +
                            formatLine("Date of Birth:", employee.getDateOfBirth()) +
                            formatLine("Address:", employee.getAddress()) +
                            formatLine("Nationality:", employee.getNationality()) +
                            formatLine("Health Conditions:", employee.getHealthConditions()) +
                            formatLine("Registration Date:", employee.getRegistrationDate()) +
                            formatLine("Employee ID:", employee.getEmployeeId()) +
                            formatLine("Job Role:", employee.getJobRole()) +
                            formatLine("Salary:", formatPounds(employee.getSalary())) +
                            formatLine("Hall Name:", employee.getHallName())
            );

            return;
        }

        // Show message if not found
        searchResultArea.setText("No student or employee found with this ID.");
    }

    /**
     * Formats one display line.
     */
    public static String formatLine(String label, String value) {

        if (value == null || value.trim().isEmpty()) {
            value = "NA";
        }

        return label + " " + value + "\n\n";
    }

    /**
     * Formats amount as British pounds.
     */
    public static String formatPounds(double amount) {
        return String.format("£%.2f", amount);
    }

    /**
     * Converts boolean to Yes or No.
     */
    public static String yesNo(boolean value) {

        if (value) {
            return "Yes";
        }

        return "No";
    }

    /**
     * Clears Search form fields.
     */
    public static void clearSearchForm() {

        searchIdField.setText("");
        searchResultArea.setText("");
        searchIdError.setText(" ");

        // Reset result colour
        searchResultArea.setBackground(Color.WHITE);
        searchResultScrollPane.getViewport().setBackground(Color.WHITE);
        searchResultPanel.setBackground(null);
    }
}