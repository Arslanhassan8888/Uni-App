package com.mycompany.uni_app_arslan;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 *
 * @author Arslan Hassan
 */

/*
 Main class for testing the application.
 And for the University Hall
*/
public class Uni_App_Arslan {

    public static void main(String[] args) {
//
//        // Run one test at a time
//
//        testPerson();
//        testStudent();
//        testEmployee();
//        testHall();
//        testStore();
//    }


        // Create the main window
        JFrame frame = new JFrame("University Halls Management System");

        // Set window size
        frame.setSize(1000, 750);

        // Centre the window on screen
        frame.setLocationRelativeTo(null);

        // Close program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout for the frame
        frame.setLayout(new BorderLayout());

        // Set background colour for the frame content
        frame.getContentPane().setBackground(new Color(104, 143, 55));


        // NORTH PANEL - TITLE AREA


        // Create title panel
        JPanel titlePanel = new JPanel(new BorderLayout());

        // Set title panel background colour
        titlePanel.setBackground(new Color(33, 76, 140));

        // Add padding around title panel
        titlePanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create main title label
        JLabel titleLabel = new JLabel("University Halls Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create subtitle label
        JLabel subTitleLabel = new JLabel("Student, Employee, Hall and Payment Records");
        subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitleLabel.setForeground(new Color(230, 235, 245));
        subTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create panel for title text
        JPanel titleTextPanel = new JPanel();
        titleTextPanel.setLayout(new BoxLayout(titleTextPanel, BoxLayout.Y_AXIS));
        titleTextPanel.setBackground(new Color(33, 76, 140));

        // Add labels to title text panel
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleTextPanel.add(titleLabel);
        titleTextPanel.add(Box.createVerticalStrut(8));
        titleTextPanel.add(subTitleLabel);

        // Add title text panel to title panel
        titlePanel.add(titleTextPanel, BorderLayout.CENTER);

        // Add title panel to frame
        frame.add(titlePanel, BorderLayout.NORTH);


        // CENTER PANEL - MAIN AREA


        // Create main centre panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(245, 247, 250));
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
        tabbedPane.setBackground(Color.WHITE);

        // Create tab panels
        JPanel studentPanel = createStyledTabPanel(
                "Student Record Form",
                "This section will contain person details and student details."
        );

        JPanel employeePanel = createStyledTabPanel(
                "Employee Record Form",
                "This section will contain person details and employee details."
        );

        JPanel hallPanel = createStyledTabPanel(
                "Hall Record Form",
                "This section will contain hall name, type, capacity and hall features."
        );

        JPanel paymentPanel = createStyledTabPanel(
                "Payment Record Form",
                "This section will contain payment details and payment status."
        );

        // Add tabs
        tabbedPane.addTab("Student", studentPanel);
        tabbedPane.addTab("Employee", employeePanel);
        tabbedPane.addTab("Hall", hallPanel);
        tabbedPane.addTab("Payment", paymentPanel);

        // Add tabbed pane to centre panel
        centerPanel.add(tabbedPane, BorderLayout.CENTER);

        // Add centre panel to frame
        frame.add(centerPanel, BorderLayout.CENTER);


        // SOUTH PANEL - BUTTON AREA


        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(230, 236, 245));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create buttons
        JButton saveButton = new JButton("Save Record");
        JButton nextButton = new JButton("Next Record");
        JButton clearButton = new JButton("Clear Form");
        JButton saveFileButton = new JButton("Save To File");
        JButton loadFileButton = new JButton("Load From File");

        // Style buttons
        styleButton(saveButton);
        styleButton(nextButton);
        styleButton(clearButton);
        styleButton(saveFileButton);
        styleButton(loadFileButton);

        // Add buttons to panel
        buttonPanel.add(saveButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveFileButton);
        buttonPanel.add(loadFileButton);

        // Add button panel to frame
        frame.add(buttonPanel, BorderLayout.SOUTH);


        // Make the window visible
        frame.setVisible(true);
    }


    /*
     Creates a styled tab panel.

     Each tab gets:
     a heading
     a description
     a preview section area
    */
    public static JPanel createStyledTabPanel(String heading, String description) {

        // Create main panel for the tab
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Create top info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 210, 225), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        // Create heading label
        JLabel headingLabel = new JLabel(heading);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setForeground(new Color(33, 76, 140));
        headingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Create description label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setForeground(new Color(70, 70, 70));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add heading and description to info panel
        infoPanel.add(headingLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(descriptionLabel);

        // Create form preview panel
        JPanel previewPanel = new JPanel();
        previewPanel.setLayout(new GridBagLayout());
        previewPanel.setBackground(Color.WHITE);
        previewPanel.setBorder(new CompoundBorder(
                new TitledBorder(
                        new LineBorder(new Color(180, 190, 210), 1, true),
                        "Form Preview Area",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 14),
                        new Color(33, 76, 140)
                ),
                new EmptyBorder(20, 20, 20, 20)
        ));

        // Create placeholder label
        JLabel previewLabel = new JLabel();
        previewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        previewLabel.setForeground(new Color(90, 90, 90));

        // Add placeholder label to preview panel
        previewPanel.add(previewLabel);

        // Create wrapper panel for spacing
        JPanel wrapperPanel = new JPanel(new BorderLayout(0, 15));
        wrapperPanel.setBackground(new Color(245, 247, 250));
        wrapperPanel.add(infoPanel, BorderLayout.NORTH);
        wrapperPanel.add(previewPanel, BorderLayout.CENTER);

        // Add wrapper panel to main panel
        mainPanel.add(wrapperPanel, BorderLayout.CENTER);

        return mainPanel;
    }


    /*
     Styles buttons so the GUI .
    */
    public static void styleButton(JButton button) {

        // Set font
        button.setFont(new Font("Arial", Font.BOLD, 13));

        // Set preferred size
        button.setPreferredSize(new Dimension(140, 38));

        // Remove focus border
        button.setFocusPainted(false);

        // Set background colour
        button.setBackground(new Color(33, 76, 140));

        // Set text colour
        button.setForeground(Color.WHITE);

        // Add border
        button.setBorder(new LineBorder(new Color(25, 60, 110), 1, true));
    }

}

















//    // Test Person class
//    public static void testPerson() {
//
//        Person p = new Person(
//                "Ali Khan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today"
//        );
//
//        System.out.println("Person Test:");
//        System.out.println(p);
//        System.out.println("-------------------");
//    }
//
//    // Test Student class
//    public static void testStudent() {
//
//        Student s = new Student(
//                "Arslan Hassan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today",
//                "S1001",
//                2,
//                "Vegetarian",
//                true,
//                120.50,
//                "Maple Hall",
//                false
//        );
//
//        System.out.println("Student Test:");
//        System.out.println(s);
//        System.out.println("-------------------");
//    }
//
//    // Test Employee class
//    public static void testEmployee() {
//
//        Employee e = new Employee(
//                "John Smith",
//                "Male",
//                "02/02/1985",
//                "London",
//                "British",
//                "None",
//                "Today",
//                "E2001",
//                "Manager",
//                2500.00,
//                "Oak Hall"
//        );
//
//        System.out.println("Employee Test:");
//        System.out.println(e);
//        System.out.println("-------------------");
//    }
//
//    // Test Hall class
//    public static void testHall() {
//
//        Hall h = new Hall(
//                "Maple Hall",
//                "Mixed",
//                100,
//                true,
//                true
//        );
//
//        System.out.println("Hall Test:");
//        System.out.println(h);
//        System.out.println("-------------------");
//    }
//
//    // Test Store class
//    public static void testStore() {
//
//        // Create a Store object
//        Store store = new Store();
//
//        // Create students
//        Student s1 = new Student(
//                "Ali Khan",
//                "Male",
//                "01/01/2000",
//                "Manchester",
//                "British",
//                "None",
//                "Today",
//                "S1001",
//                1,
//                "Vegetarian",
//                true,
//                120.50,
//                "Maple Hall",
//                false
//        );
//
//        Student s2 = new Student(
//                "Sara Ahmed",
//                "Female",
//                "02/02/2001",
//                "Leeds",
//                "British",
//                "Asthma",
//                "Today",
//                "S1002",
//                2,
//                "Vegan",
//                false,
//                130.00,
//                "Oak Hall",
//                true
//        );
//
//        // Create employee
//        Employee e1 = new Employee(
//                "John Smith",
//                "Male",
//                "10/10/1985",
//                "London",
//                "British",
//                "None",
//                "Today",
//                "E2001",
//                "Manager",
//                2500.00,
//                "Maple Hall"
//        );
//
//        // Create hall
//        Hall h1 = new Hall(
//                "Maple Hall",
//                "Mixed",
//                100,
//                true,
//                true
//        );
//
//        // Add objects to Store
//        store.addStudent(s1);
//        store.addStudent(s2);
//        store.addEmployee(e1);
//        store.addHall(h1);
//
//        // Display next student records
//        System.out.println("Store Student Test:");
//        System.out.println(store.getNextStudent());
//        System.out.println(store.getNextStudent());
//        System.out.println(store.getNextStudent());
//        System.out.println("-------------------");
//
//        // Display next employee record
//        System.out.println("Store Employee Test:");
//        System.out.println(store.getNextEmployee());
//        System.out.println("-------------------");
//
//        // Display next hall record
//        System.out.println("Store Hall Test:");
//        System.out.println(store.getNextHall());
//        System.out.println("-------------------");
//
//        // Test Payment and Store
//        Payment p1 = new Payment(
//                "P1001",
//                "S1001",
//                "Arslan Hassan",
//                250.00,
//                "20/04/2026",
//                "Card",
//                true
//        );
//
//        Payment p2 = new Payment(
//                "P1002",
//                "S1002",
//                "Sara Ahmed",
//                180.00,
//                "21/04/2026",
//                "Cash",
//                false
//        );
//
//        ;
//
//        // Add payments to store
//        store.addPayment(p1);
//        store.addPayment(p2);
//
//        // Display payments one by one
//        System.out.println("Payment Test:");
//        System.out.println(store.getNextPayment());
//        System.out.println(store.getNextPayment());
//        System.out.println(store.getNextPayment());
//        System.out.println("-------------------");
//
//    }
//}