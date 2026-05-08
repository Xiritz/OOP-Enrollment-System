package org.example.service;

import java.util.HashMap;
import java.util.Map;

public class TuitionFeePaymentServiceImpl implements TuitionFeePaymentService {
    private final double PRICE_PER_UNIT = 1000.00;
    private Map<String, Double> studentBalances = new HashMap<>();

    @Override
    public double calculateTuitionFee(String studentId, int units, double discountRate) {
        double totalTuition;
        if (discountRate != 0) {
            double discountPrice = (units * PRICE_PER_UNIT) * discountRate;
            totalTuition = (units * PRICE_PER_UNIT) - discountPrice;
        } else {
            totalTuition = (units * PRICE_PER_UNIT);
        }
        
        studentBalances.put(studentId, totalTuition);
        return totalTuition;
    }

    @Override
    public void makePayment(String studentId, double amount) {
        if (!studentBalances.containsKey(studentId)) {
            System.out.println("No tuition record found for Student ID: " + studentId);
        } else if (amount <= 0) {
            System.out.println("Invalid payment amount. Must be greater than zero.");
        } else {
            double currentBalance = studentBalances.get(studentId);
            if (amount > currentBalance) {
                System.out.println("Overpayment detected! Current balance is: " + currentBalance + ". Rejecting transaction.");
            } else {
                double newBalance = currentBalance - amount;
                studentBalances.put(studentId, newBalance);
                System.out.println("Payment of " + amount + " successful for Student " + studentId + ".");
                if (newBalance == 0) {
                    System.out.println("Student " + studentId + " has fully paid their tuition.");
                }
            }
        }
    }

    @Override
    public double getRemainingBalance(String studentId) {
        if (studentBalances.containsKey(studentId)) {
            return studentBalances.get(studentId);
        } else {
            System.out.println("No balance found for Student: " + studentId);
            return 0;
        }
    }

    @Override
    public boolean isFullyPaid(String studentId) {
        if (studentBalances.containsKey(studentId)) {
            return studentBalances.get(studentId) == 0;
        } else {
            return false;
        }
    }
}
