package org.example.service;

public class TuitionFeePaymentServiceImpl implements TuitionFeePaymentService {
    private final double PRICE_PER_UNIT = 1000.00;
    private double balance;
    private double totalTuition;

    public double calculateTuitionFee(int units,double discountRate){
        if (discountRate !=0){
            double discountPrice = (units*PRICE_PER_UNIT)*discountRate;
            totalTuition = (units*PRICE_PER_UNIT) - discountPrice;
            balance = totalTuition;
            return totalTuition;
        } else{
            totalTuition = (units*PRICE_PER_UNIT);
            balance = totalTuition;
            return totalTuition;
        }
    }

    public void makePayment(double amount){
        balance -=amount;
    }

    public double getRemainingBalance(){
        return balance;
    }

    public boolean isFullyPaid(){
        return balance==0;
    }
}
