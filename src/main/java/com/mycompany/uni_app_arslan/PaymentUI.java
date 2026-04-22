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
    static JTextField paymentRentField;
    static JTextField paymentAmountPaidField;
    static JTextField paymentRemainingField;
    static JTextField paymentStatusField;

    // Date spinner for payment date
    static JSpinner paymentDateSpinner;

    // Combo box for payment method
    static JComboBox<String> paymentMethodCombo;

    // Text area for record display
    static JTextArea paymentRecordArea;

    // Scroll pane for record area
    static JScrollPane paymentRecordScrollPane;

    // Record panel
    static JPanel paymentRecordPanel;

    // PAYMENT ERROR LABELS
    // These show inline validation messages

    static JLabel paymentIdError;
    static JLabel paymentStudentIdError;
    static JLabel paymentAmountPaidError;
    static JLabel paymentDateError;

    /*
     Creates PAYMENT TAB.
     This includes:
     payment details
     record display area
    */
    public static JPanel createPaymentTab() {

        // Main panel for Payment tab
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 2, 2));

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
        Dimension labelSize = new Dimension(120, 20);

        // Create error labels
        paymentIdError = createErrorLabel();
        paymentStudentIdError = createErrorLabel();
        paymentAmountPaidError = createErrorLabel();
        paymentDateError = createErrorLabel();

        // Create fields
        paymentIdField = new JTextField(15);
        paymentStudentIdField = new JTextField(15);
        paymentStudentNameField = new JTextField(15);
        paymentRentField = new JTextField(15);
        paymentAmountPaidField = new JTextField(15);
        paymentRemainingField = new JTextField(15);
        paymentStatusField = new JTextField(15);

        // Auto fields should not be edited by user
        paymentStudentNameField.setEditable(false);
        paymentRentField.setEditable(false);
        paymentRemainingField.setEditable(false);
        paymentStatusField.setEditable(false);

        // Create date spinner
        paymentDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor paymentDateEditor = new JSpinner.DateEditor(paymentDateSpinner, "dd/MM/yyyy");
        paymentDateSpinner.setEditor(paymentDateEditor);

        // Create options
        paymentMethodCombo = new JComboBox<>(new String[]{
                "Cash",
                "Card",
                "Bank Transfer"
        });

        // Add rows to payment panel
        paymentPanel.add(makeFieldBlock(makeRow("Payment ID:", paymentIdField, labelSize), paymentIdError));
        paymentPanel.add(makeFieldBlock(makeRow("Student ID:", paymentStudentIdField, labelSize), paymentStudentIdError));
        paymentPanel.add(makeFieldBlock(makeRow("Student Name:", paymentStudentNameField, labelSize), createErrorLabel()));
        paymentPanel.add(makeFieldBlock(makeRow("Rent Amount:", paymentRentField, labelSize), createErrorLabel()));
        paymentPanel.add(makeFieldBlock(makeRow("Amount Paid:", paymentAmountPaidField, labelSize), paymentAmountPaidError));
        paymentPanel.add(makeFieldBlock(makeRow("Remaining:", paymentRemainingField, labelSize), createErrorLabel()));
        paymentPanel.add(makeFieldBlock(makeRow("Payment Date:", paymentDateSpinner, labelSize), paymentDateError));
        paymentPanel.add(makeFieldBlock(makeRow("Payment Method:", paymentMethodCombo, labelSize), createErrorLabel()));
        paymentPanel.add(makeFieldBlock(makeRow("Status:", paymentStatusField, labelSize), createErrorLabel()));

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

        // Put form container inside scroll pane
        JScrollPane formScrollPane = new JScrollPane(formContainer);
        formScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        formScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add form and record display to main panel
        mainPanel.add(formScrollPane);
        mainPanel.add(paymentRecordPanel);

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

        JLabel label = new JLabel("");
        label.setForeground(Color.RED);
        label.setPreferredSize(new Dimension(220, 12));
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
     Clears Payment error labels.
    */
    public static void clearPaymentErrors() {

        paymentIdError.setText("");
        paymentStudentIdError.setText("");
        paymentAmountPaidError.setText("");
        paymentDateError.setText("");
    }

    /*
     Validates Payment form.
    */
    public static boolean validatePaymentForm() {

        boolean valid = true;

        clearPaymentErrors();

        if (paymentIdField.getText().trim().isEmpty()) {
            paymentIdError.setText("Payment ID is required.");
            valid = false;
        } else if (!paymentIdField.getText().trim().matches("\\d+")) {
            paymentIdError.setText("Payment ID must be positive numbers only.");
            valid = false;
        }

        if (paymentStudentIdField.getText().trim().isEmpty()) {
            paymentStudentIdError.setText("Student ID is required.");
            valid = false;
        } else if (!paymentStudentIdField.getText().trim().matches("\\d+")) {
            paymentStudentIdError.setText("Student ID must be positive numbers only.");
            valid = false;
        }

        if (paymentAmountPaidField.getText().trim().isEmpty()) {
            paymentAmountPaidError.setText("Amount paid is required.");
            valid = false;
        } else {
            try {
                double amount = Double.parseDouble(paymentAmountPaidField.getText().trim());

                if (amount < 0) {
                    paymentAmountPaidError.setText("Amount paid must not be negative.");
                    valid = false;
                }

            } catch (Exception ex) {
                paymentAmountPaidError.setText("Amount paid must be a valid number.");
                valid = false;
            }
        }

        String paymentDate = getDateText(paymentDateSpinner);
        if (paymentDate == null || paymentDate.trim().isEmpty()) {
            paymentDateError.setText("Payment date is required.");
            valid = false;
        }

        return valid;
    }

    /*
     Saves Payment record into Store.
    */
    public static void savePaymentRecord() {
        JOptionPane.showMessageDialog(null, "Payment save logic will be updated in next step.");
    }

    /*
     Shows next Payment record from Store.
    */
    public static void showNextPaymentRecord() {
        JOptionPane.showMessageDialog(null, "Payment next record logic will be updated in next step.");
    }

    /*
     Clears Payment form fields.
    */
    public static void clearPaymentForm() {

        paymentIdField.setText("");
        paymentStudentIdField.setText("");
        paymentStudentNameField.setText("");
        paymentRentField.setText("");
        paymentAmountPaidField.setText("");
        paymentRemainingField.setText("");
        paymentStatusField.setText("");

        paymentMethodCombo.setSelectedIndex(0);

        paymentDateSpinner.setValue(new Date());

        paymentRecordArea.setText("");

        clearPaymentErrors();

        // Reset background when form is cleared
        paymentRecordArea.setBackground(java.awt.Color.WHITE);
        paymentRecordScrollPane.getViewport().setBackground(java.awt.Color.WHITE);
        paymentRecordPanel.setBackground(null);
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
}