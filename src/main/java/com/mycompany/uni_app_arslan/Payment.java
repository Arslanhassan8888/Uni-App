package com.mycompany.uni_app_arslan;

/**
 * The Payment class represents a rent payment record.
 *
 * Payment class represents a payment in the university halls system.
 *
 * This class stores payment details for a student.
 * It can be used later to record rent payments.
 *
 * @author Arslan Hassan
 */
public class Payment {

    /** Unique payment ID */
    private String paymentId;

    /** Student ID linked to the payment */
    private String studentId;

    /** Student name linked to the payment */
    private String studentName;

    /** Payment Amount */
    private double amount;

    /** Date of payment */
    private String paymentDate;

    /** Payment method (e.g. Cash, Card, Bank Transfer) */
    private String paymentMethod;

    /** Indicates if payment has been completed */
    private boolean paid;


    /** Constructors */

    /** Default constructor */
    public Payment() {
    }

    /** Full constructor */
    public Payment(String paymentId, String studentId, String studentName,
                   double amount, String paymentDate,
                   String paymentMethod, boolean paid) {

        this.paymentId = paymentId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paid = paid;
    }


    /** Getters and Setters */

    /** Returns the payment ID */
    public String getPaymentId() {
        return paymentId;
    }

    /** Sets the payment ID */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /** Returns the student ID */
    public String getStudentId() {
        return studentId;
    }

    /** Sets the student ID */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /** Returns the student name */
    public String getStudentName() {
        return studentName;
    }

    /** Sets the student name */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /** Returns the payment amount */
    public double getAmount() {
        return amount;
    }

    /** Sets the payment amount */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Returns the payment date */
    public String getPaymentDate() {
        return paymentDate;
    }

    /** Sets the payment date */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /** Returns the payment method */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /** Sets the payment method */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /** Returns true if payment has been made */
    public boolean isPaid() {
        return paid;
    }

    /** Sets the payment status */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    /** toString method */

    /** Returns a readable version of the payment object */
    @Override
    public String toString() {
        return "Payment: " +
                "Payment ID = " + paymentId +
                ", Student ID = " + studentId +
                ", Student Name = " + studentName +
                ", Amount = " + amount +
                ", Payment Date = " + paymentDate +
                ", Payment Method = " + paymentMethod +
                ", Paid = " + paid;
    }
}