package com.mycompany.uni_app_arslan;

import java.awt.BorderLayout;
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

    // HALL OPTIONS
    // These are used in Student and Employee tabs
    public static final String[] HALL_OPTIONS = {
            "Ground Floor Hall",
            "First Floor Hall",
            "Second Floor Hall",
            "Third Floor Hall",
            "Fourth Floor Hall"
    };

    // JOB ROLE OPTIONS
    // These are used in Employee tab
    public static final String[] JOB_ROLE_OPTIONS = {
            "Cleaner",
            "Security",
            "Receptionist",
            "Hall Manager",
            "Maintenance",
            "Warden"
    };

    // Tabbed pane
    static JTabbedPane tabbedPane;

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
        tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("Student", StudentUI.createStudentTab());
        tabbedPane.addTab("Employee", EmployeeUI.createEmployeeTab());
        tabbedPane.addTab("Hall", HallUI.createHallTab());
        tabbedPane.addTab("Payment", PaymentUI.createPaymentTab());
        tabbedPane.addTab("Search Person", SearchUI.createSearchTab());

        // Add tabbed pane to centre panel
        centerPanel.add(tabbedPane, BorderLayout.CENTER);

        return centerPanel;
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
     Delete Tab Records
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
        JButton deleteTabRecords = new JButton("Delete Tab Records");

        // Save record
        save.addActionListener(e -> {

            // Check which tab is selected
            int selectedTab = tabbedPane.getSelectedIndex();

            if (selectedTab == 0) {
                StudentUI.saveStudentRecord();
            } else if (selectedTab == 1) {
                EmployeeUI.saveEmployeeRecord();
            } else if (selectedTab == 2) {
                HallUI.saveHallRecord();
            } else if (selectedTab == 3) {
                PaymentUI.savePaymentRecord();
            } else {
                JOptionPane.showMessageDialog(null, "This tab is not ready for saving.");
            }
        });

        // Show next record
        next.addActionListener(e -> {

            // Check which tab is selected
            int selectedTab = tabbedPane.getSelectedIndex();

            if (selectedTab == 0) {
                StudentUI.showNextStudentRecord();
            } else if (selectedTab == 1) {
                EmployeeUI.showNextEmployeeRecord();
            } else if (selectedTab == 2) {
                HallUI.showNextHallRecord();
            } else if (selectedTab == 3) {
                PaymentUI.showNextPaymentRecord();
            } else {
                JOptionPane.showMessageDialog(null, "This tab is not ready for next record.");
            }
        });

        // Clear form
        clear.addActionListener(e -> {

            // Check which tab is selected
            int selectedTab = tabbedPane.getSelectedIndex();

            if (selectedTab == 0) {
                StudentUI.clearStudentForm();
            } else if (selectedTab == 1) {
                EmployeeUI.clearEmployeeForm();
            } else if (selectedTab == 2) {
                HallUI.clearHallForm();
            } else if (selectedTab == 3) {
                PaymentUI.clearPaymentForm();
            } else if (selectedTab == 4) {
                SearchUI.clearSearchForm();
            } else {
                JOptionPane.showMessageDialog(null, "This tab is not ready yet.");
            }
        });

        // Save to file
        saveFile.addActionListener(e -> {

            FileManager.saveStudents(store);
            FileManager.saveEmployees(store);
            FileManager.saveHalls(store);
            FileManager.savePayments(store);

            JOptionPane.showMessageDialog(null, "All records saved to file.");
        });

        // Load from file
        loadFile.addActionListener(e -> {

            FileManager.loadStudents(store);
            FileManager.loadEmployees(store);
            FileManager.loadHalls(store);
            FileManager.loadPayments(store);

            JOptionPane.showMessageDialog(null, "All records loaded from file.");
        });

        // Delete tab records
        deleteTabRecords.addActionListener(e -> {

            // Check which tab is selected
            int selectedTab = tabbedPane.getSelectedIndex();

            // Confirm delete
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete all records in this tab from system memory?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            if (selectedTab == 0) {
                store.clearStudents();
                StudentUI.clearStudentForm();
                JOptionPane.showMessageDialog(null, "All student records deleted from memory.");
            } else if (selectedTab == 1) {
                store.clearEmployees();
                EmployeeUI.clearEmployeeForm();
                JOptionPane.showMessageDialog(null, "All employee records deleted from memory.");
            } else if (selectedTab == 2) {
                store.clearHalls();
                HallUI.clearHallForm();
                JOptionPane.showMessageDialog(null, "All hall records deleted from memory.");
            } else if (selectedTab == 3) {
                store.clearPayments();
                PaymentUI.clearPaymentForm();
                JOptionPane.showMessageDialog(null, "All payment records deleted from memory.");
            } else if (selectedTab == 4) {
                JOptionPane.showMessageDialog(null, "Search tab has no records to delete.");
            } else {
                JOptionPane.showMessageDialog(null, "This tab is not ready yet.");
            }
        });

        // Add buttons to panel
        panel.add(save);
        panel.add(next);
        panel.add(clear);
        panel.add(saveFile);
        panel.add(loadFile);
        panel.add(deleteTabRecords);

        return panel;
    }
}