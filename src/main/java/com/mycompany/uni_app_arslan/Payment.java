package com.mycompany.uni_app_arslan;

/**
 * Payment class represents a rent payment record in the university halls system.
 *
 * This class stores payment details for a student, including payment ID,
 * student details, payment amount, date, method, and status.
 *
 * @author Arslan Hassan
 */
public class Payment {

    /** Unique payment ID. */
    private String paymentId;

    /** Student ID linked to the payment. */
    private String studentId;

    /** Student name linked to the payment. */
    private String studentName;

    /** Payment amount. */
    private double amount;

    /** Date of payment. */
    private String paymentDate;

    /** Payment method (e.g. Cash, Card, Bank Transfer). */
    private String paymentMethod;

    /** Indicates if payment has been completed. */
    private boolean paid;


    /** CONSTRUCTORS */

    /**
     * Default constructor.
     */
    public Payment() {
    }

    /**
     * Full constructor.
     *
     * @param paymentId unique payment ID
     * @param studentId student ID linked to the payment
     * @param studentName student name linked to the payment
     * @param amount payment amount
     * @param paymentDate date of payment
     * @param paymentMethod payment method
     * @param paid true if payment has been completed
     */
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


    /** GETTERS AND SETTERS */

    /**
     * Returns the payment ID.
     *
     * @return payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment ID.
     *
     * @param paymentId payment ID
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Returns the student ID.
     *
     * @return student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId student ID
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns the student name.
     *
     * @return student name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student name.
     *
     * @param studentName student name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Returns the payment amount.
     *
     * @return payment amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the payment amount.
     *
     * @param amount payment amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the payment date.
     *
     * @return payment date
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the payment date.
     *
     * @param paymentDate payment date
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Returns the payment method.
     *
     * @return payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     *
     * @param paymentMethod payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returns true if payment has been made.
     *
     * @return payment status
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Sets the payment status.
     *
     * @param paid payment status
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    /** toString method */

    /**
     * Returns a readable version of the payment object.
     *
     * @return payment details as a string
     */
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