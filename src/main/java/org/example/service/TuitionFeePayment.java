package org.example.service;

public interface TuitionFeePayment {
    double calculateTuitionFee(int units, double discountRate);
    void makePayment(double amount);
    double getRemainingBalance();
    boolean isFullyPaid();
}
