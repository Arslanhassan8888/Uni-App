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

        // Set background colour
        frame.getContentPane().setBackground(new Color(245, 247, 250));

        // Add the main GUI parts
        frame.add(createHeaderPanel(), BorderLayout.NORTH);
        frame.add(createCenterPanel(), BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);

        // Make the window visible
        frame.setVisible(true);
    }


    /*
     Creates the title area at the top of the window.
    */
    public static JPanel createHeaderPanel() {

        // Create title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(33, 76, 140));
        titlePanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create title label
        JLabel titleLabel = new JLabel("University Halls Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create subtitle label
        JLabel subTitleLabel = new JLabel("Student, Employee, Hall and Payment Records");
        subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitleLabel.setForeground(new Color(230, 235, 245));
        subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create title text panel
        JPanel titleTextPanel = new JPanel();
        titleTextPanel.setLayout(new BoxLayout(titleTextPanel, BoxLayout.Y_AXIS));
        titleTextPanel.setBackground(new Color(33, 76, 140));

        // Add labels to title panel
        titleTextPanel.add(titleLabel);
        titleTextPanel.add(Box.createVerticalStrut(8));
        titleTextPanel.add(subTitleLabel);

        // Add title text panel to main title panel
        titlePanel.add(titleTextPanel, BorderLayout.CENTER);

        return titlePanel;
    }


    /*
     Creates the centre area with all tabs.
    */
    public static JPanel createCenterPanel() {

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

        return centerPanel;
    }


    /*
     Creates the bottom button area.
    */
    public static JPanel createButtonPanel() {

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

        return buttonPanel;
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

        // Add heading and description
        infoPanel.add(headingLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(descriptionLabel);

        // Create preview area
        JPanel previewPanel = new JPanel(new GridBagLayout());
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

        // Placeholder label
        JLabel previewLabel = new JLabel("Form fields will be added here step by step.");
        previewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        previewLabel.setForeground(new Color(90, 90, 90));
        previewPanel.add(previewLabel);

        // Wrapper panel
        JPanel wrapperPanel = new JPanel(new BorderLayout(0, 15));
        wrapperPanel.setBackground(new Color(245, 247, 250));
        wrapperPanel.add(infoPanel, BorderLayout.NORTH);
        wrapperPanel.add(previewPanel, BorderLayout.CENTER);

        // Add wrapper panel to main panel
        mainPanel.add(wrapperPanel, BorderLayout.CENTER);

        return mainPanel;
    }


    /*
     Styles buttons so the GUI looks cleaner and more professional.
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