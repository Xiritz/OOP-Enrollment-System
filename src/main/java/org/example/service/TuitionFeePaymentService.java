package org.example.service;

public interface TuitionFeePaymentService {
    double calculateTuitionFee(String studentId, int units, double discountRate);
    void makePayment(String studentId, double amount);
    double getRemainingBalance(String studentId);
    boolean isFullyPaid(String studentId);
}
