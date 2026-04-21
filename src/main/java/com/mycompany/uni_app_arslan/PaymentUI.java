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
 Payment user interface.
 This class handles:
 Payment form
 Payment record display
 Save record
 Next record
 Clear form
*/
public class PaymentUI {

    // PAYMENT FORM FIELDS
    // These will store payment input

    // Text fields for payment details
    static JTextField paymentIdField;
    static JTextField paymentStudentIdField;
    static JTextField paymentStudentNameField;
    static JTextField paymentAmountField;
    static JTextField paymentDateField;

    // Combo box for payment method
    static JComboBox<String> paymentMethodCombo;

    // Check box for paid status
    static JCheckBox paymentPaidCheck;

    // Text area for record display
    static JTextArea paymentRecordArea;

    // Scroll pane for record area
    static JScrollPane paymentRecordScrollPane;

    // Record panel
    static JPanel paymentRecordPanel;

    /*
     Creates PAYMENT TAB.
     This includes:
     payment details
     record display area
    */
    public static JPanel createPaymentTab() {

        // Main panel for Payment tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // FORM CONTAINER
        // This holds the form section on the left
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(BorderFactory.createTitledBorder("Payment Form"));

        // PAYMENT DETAILS SECTION
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment Details"));

        // Common label size
        Dimension labelSize = new Dimension(140, 25);

        // Create fields
        paymentIdField = new JTextField(15);
        paymentStudentIdField = new JTextField(15);
        paymentStudentNameField = new JTextField(15);
        paymentAmountField = new JTextField(15);
        paymentDateField = new JTextField(15);

        // Create options
        paymentMethodCombo = new JComboBox<>(new String[]{
                "Cash",
                "Card",
                "Bank Transfer"
        });

        paymentPaidCheck = new JCheckBox("Paid");

        // Add rows to payment panel
        paymentPanel.add(makeRow("Payment ID:", paymentIdField, labelSize));
        paymentPanel.add(makeRow("Student ID:", paymentStudentIdField, labelSize));
        paymentPanel.add(makeRow("Student Name:", paymentStudentNameField, labelSize));
        paymentPanel.add(makeRow("Amount:", paymentAmountField, labelSize));
        paymentPanel.add(makeRow("Payment Date:", paymentDateField, labelSize));
        paymentPanel.add(makeRow("Payment Method:", paymentMethodCombo, labelSize));
        paymentPanel.add(makeRow("Paid Status:", paymentPaidCheck, labelSize));

        // Add section to form container
        formContainer.add(paymentPanel);

        // RECORD DISPLAY SECTION
        // This shows the saved record on the right
        paymentRecordPanel = new JPanel(new BorderLayout());
        paymentRecordPanel.setBorder(BorderFactory.createTitledBorder("Payment Record Display"));

        paymentRecordArea = new JTextArea(20, 30);
        paymentRecordArea.setEditable(false);
        paymentRecordArea.setLineWrap(true);
        paymentRecordArea.setWrapStyleWord(true);

        paymentRecordScrollPane = new JScrollPane(paymentRecordArea);

        paymentRecordPanel.add(paymentRecordScrollPane, BorderLayout.CENTER);

        // Add form and record display to main panel
        mainPanel.add(formContainer);
        mainPanel.add(paymentRecordPanel);

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
     Saves Payment record into Store.
    */
    public static void savePaymentRecord() {

        try {
            Payment payment = new Payment(
                    paymentIdField.getText(),
                    paymentStudentIdField.getText(),
                    paymentStudentNameField.getText(),
                    Double.parseDouble(paymentAmountField.getText()),
                    paymentDateField.getText(),
                    (String) paymentMethodCombo.getSelectedItem(),
                    paymentPaidCheck.isSelected()
            );

            Uni_App_Arslan.store.addPayment(payment);

            // Show saved payment in display area
            paymentRecordArea.setText(
                    "PAYMENT RECORD\n\n" +
                            formatLine("Payment ID:", payment.getPaymentId()) +
                            formatLine("Student ID:", payment.getStudentId()) +
                            formatLine("Student Name:", payment.getStudentName()) +
                            formatLine("Amount:", String.valueOf(payment.getAmount())) +
                            formatLine("Payment Date:", payment.getPaymentDate()) +
                            formatLine("Payment Method:", payment.getPaymentMethod()) +
                            formatLine("Paid:", yesNo(payment.isPaid()))
            );

            JOptionPane.showMessageDialog(null, "Payment record saved.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid payment data.");
        }
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
}

