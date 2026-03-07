package org.example.service;

public class TuitionFeePayment {
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;

    public double calculateTuitionFee(int units,int discountRate){
        if (discountRate !=0){
            double discountPrice = (units*pricePerUnit)*discountRate;
            totalTuition = (units*pricePerUnit) - discountPrice;
            return totalTuition;
        } else{
            totalTuition = (units*pricePerUnit);
            return totalTuition;
        }
    }

    public void makePayment(double amount){
        balance +=amount;
    }

    public double getRemainingBalance(){
        balance -=totalTuition;
        return balance;
    }

    public boolean isFullyPaid(){
        return balance==0;
    }
}
