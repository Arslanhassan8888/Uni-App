package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Arslan Hassan
 */

/*
 Hall user interface.
 This class handles:
 Hall form
 Hall record display
 Save record
 Next record
 Clear form
*/
public class HallUI {

    // HALL FORM FIELDS
    // These will store hall input

    // Combo box for hall name
    static JComboBox<String> hallNameCombo;

    // Combo box for hall type
    static JComboBox<String> hallTypeCombo;

    // Combo box for resident type
    static JComboBox<String> residentTypeCombo;

    // Text field for resident ID
    static JTextField residentIdField;

    // Combo box for room type
    static JComboBox<String> roomTypeCombo;

    // Check boxes for hall options
    static JCheckBox hallVegetarianCheck;
    static JCheckBox hallVeganCheck;

    // Text area for record display
    static JTextArea hallRecordArea;

    // Scroll pane for record area
    static JScrollPane hallRecordScrollPane;

    // Record panel
    static JPanel hallRecordPanel;

    /*
     Creates HALL TAB.
     This includes:
     hall details
     record display area
    */
    public static JPanel createHallTab() {

        // Main panel for Hall tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // FORM CONTAINER
        // This holds the form section on the left
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(BorderFactory.createTitledBorder("Hall Form"));

        // HALL DETAILS SECTION
        JPanel hallPanel = new JPanel();
        hallPanel.setLayout(new BoxLayout(hallPanel, BoxLayout.Y_AXIS));
        hallPanel.setBorder(BorderFactory.createTitledBorder("Hall Details"));

        // Common label size
        Dimension labelSize = new Dimension(140, 25);

        // Create options
        hallNameCombo = new JComboBox<>(Uni_App_Arslan.HALL_OPTIONS);

        hallTypeCombo = new JComboBox<>(new String[]{
                "Mixed",
                "Female Only",
                "Male Only",
                "Quiet"
        });

        residentTypeCombo = new JComboBox<>(new String[]{
                "Student",
                "Employee"
        });

        roomTypeCombo = new JComboBox<>(new String[]{
                "1 Person",
                "2 Person",
                "3 Person",
                "4 Person"
        });

        // Create text field
        residentIdField = new JTextField(15);

        // Create check boxes
        hallVegetarianCheck = new JCheckBox("Yes");
        hallVeganCheck = new JCheckBox("Yes");

        // Add rows to hall panel
        hallPanel.add(makeRow("Resident Type:", residentTypeCombo, labelSize));
        hallPanel.add(makeRow("Resident ID:", residentIdField, labelSize));
        hallPanel.add(makeRow("Hall Name:", hallNameCombo, labelSize));
        hallPanel.add(makeRow("Hall Type:", hallTypeCombo, labelSize));
        hallPanel.add(makeRow("Room Type:", roomTypeCombo, labelSize));
        hallPanel.add(makeRow("Vegetarian Friendly:", hallVegetarianCheck, labelSize));
        hallPanel.add(makeRow("Vegan Friendly:", hallVeganCheck, labelSize));

        // Add section to form container
        formContainer.add(hallPanel);

        // RECORD DISPLAY SECTION
        // This shows the saved record on the right
        hallRecordPanel = new JPanel(new BorderLayout());
        hallRecordPanel.setBorder(BorderFactory.createTitledBorder("Hall Record Display"));

        hallRecordArea = new JTextArea(20, 30);
        hallRecordArea.setEditable(false);
        hallRecordArea.setLineWrap(true);
        hallRecordArea.setWrapStyleWord(true);

        hallRecordScrollPane = new JScrollPane(hallRecordArea);

        hallRecordPanel.add(hallRecordScrollPane, BorderLayout.CENTER);

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(hallRecordPanel);

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
 Saves Hall record into Store.
*/
    public static void saveHallRecord() {

        try {
            Hall hall = new Hall(
                    (String) hallNameCombo.getSelectedItem(),
                    (String) hallTypeCombo.getSelectedItem(),
                    (String) residentTypeCombo.getSelectedItem(),
                    residentIdField.getText(),
                    (String) roomTypeCombo.getSelectedItem(),
                    hallVegetarianCheck.isSelected(),
                    hallVeganCheck.isSelected()
            );

            Uni_App_Arslan.store.addHall(hall);
            JOptionPane.showMessageDialog(null, "Hall record saved.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid hall data.");
        }
    }

    /*
 Shows next Hall record from Store.
*/
    public static void showNextHallRecord() {

        Hall h = Uni_App_Arslan.store.getNextHall();

        if (h == null) {
            JOptionPane.showMessageDialog(null, "No hall records saved.");
            return;
        }

        // Show colour only when Next Record is clicked
        java.awt.Color lightYellow = new java.awt.Color(255, 250, 230);
        hallRecordArea.setBackground(lightYellow);
        hallRecordScrollPane.getViewport().setBackground(lightYellow);
        hallRecordPanel.setBackground(lightYellow);

        // Show hall details in form
        residentTypeCombo.setSelectedItem(h.getResidentType());
        residentIdField.setText(h.getResidentId());
        hallNameCombo.setSelectedItem(h.getHallName());
        hallTypeCombo.setSelectedItem(h.getHallType());
        roomTypeCombo.setSelectedItem(h.getRoomType());
        hallVegetarianCheck.setSelected(h.isVegetarianFriendly());
        hallVeganCheck.setSelected(h.isVeganFriendly());

        // Show record in display area
        hallRecordArea.setText(
                "HALL RECORD\n\n" +
                        formatLine("Resident Type:", h.getResidentType()) +
                        formatLine("Resident ID:", h.getResidentId()) +
                        formatLine("Hall Name:", h.getHallName()) +
                        formatLine("Hall Type:", h.getHallType()) +
                        formatLine("Room Type:", h.getRoomType()) +
                        formatLine("Vegetarian Friendly:", yesNo(h.isVegetarianFriendly())) +
                        formatLine("Vegan Friendly:", yesNo(h.isVeganFriendly()))
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
     Clears Hall form fields.
    */
    public static void clearHallForm() {

        residentTypeCombo.setSelectedIndex(0);
        residentIdField.setText("");
        hallNameCombo.setSelectedIndex(0);
        hallTypeCombo.setSelectedIndex(0);
        roomTypeCombo.setSelectedIndex(0);
        hallVegetarianCheck.setSelected(false);
        hallVeganCheck.setSelected(false);

        hallRecordArea.setText("");

        // Reset background when form is cleared
        hallRecordArea.setBackground(java.awt.Color.WHITE);
        hallRecordScrollPane.getViewport().setBackground(java.awt.Color.WHITE);
        hallRecordPanel.setBackground(null);
    }
}