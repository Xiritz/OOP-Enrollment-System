package org.example.service;

import org.example.model.Payment;
import java.util.ArrayList;
import java.util.List;

public class TuitionFeePaymentServiceImpl implements TuitionFeePaymentService {
    private final double PRICE_PER_UNIT = 1000.00;
    
    private List<Payment> paymentRecords = new ArrayList<>();

    private Payment findPaymentRecord(String studentId) {
        for (Payment payment : paymentRecords) {
            if (payment.getStudentId().equals(studentId)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public double calculateTuitionFee(String studentId, int units, double discountRate) {
        double totalTuition;
        if (discountRate != 0) {
            double discountPrice = (units * PRICE_PER_UNIT) * discountRate;
            totalTuition = (units * PRICE_PER_UNIT) - discountPrice;
        } else {
            totalTuition = (units * PRICE_PER_UNIT);
        }
        
        Payment payment = findPaymentRecord(studentId);
        if (payment != null) {
            payment.setTotalTuition(totalTuition);
            payment.setRemainingBalance(totalTuition); 
        } else {
            paymentRecords.add(new Payment(studentId, totalTuition));
        }
        
        return totalTuition;
    }

    @Override
    public void makePayment(String studentId, double amount) {
        Payment payment = findPaymentRecord(studentId);
        
        if (payment == null) {
            System.out.println("No tuition record found for Student ID: " + studentId);
        } else if (amount <= 0) {
            System.out.println("Invalid payment amount. Must be greater than zero.");
        } else {
            double currentBalance = payment.getRemainingBalance();
            if (amount > currentBalance) {
                System.out.println("Overpayment detected! Current balance is: " + currentBalance + ". Rejecting transaction.");
            } else {
                payment.setRemainingBalance(currentBalance - amount);
                System.out.println("Payment of " + amount + " successful for Student " + studentId + ".");
                if (payment.getRemainingBalance() == 0) {
                    System.out.println("Student " + studentId + " has fully paid their tuition.");
                }
            }
        }
    }

    @Override
    public double getRemainingBalance(String studentId) {
        Payment payment = findPaymentRecord(studentId);
        if (payment != null) {
            return payment.getRemainingBalance();
        } else {
            System.out.println("No balance found for Student: " + studentId);
            return 0;
        }
    }

    @Override
    public boolean isFullyPaid(String studentId) {
        Payment payment = findPaymentRecord(studentId);
        if (payment != null) {
            return payment.getRemainingBalance() == 0;
        } else {
            return false;
        }
    }
}
