package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionfee;
    @BeforeEach
    void setUp(){
    tuitionfee = new TuitionFeePayment();
    }

    @Test
    void calculateTutionFee(){
        assertEquals(3000, tuitionfee.calculateTuitionFee(3,0));
    }

    @Test
    void shouldCalculateTuitionWithDiscountRate(){
        assertEquals(2700, tuitionfee.calculateTuitionFee(3,0.10));

    }

    @Test
    void balanceShouldUpdate(){
        tuitionfee.calculateTuitionFee(3,0);
        tuitionfee.makePayment(500);
        assertEquals(2500, tuitionfee.getRemainingBalance());
    }

    @Test
    void balanceShouldShow(){
        tuitionfee.calculateTuitionFee(3,0);
        assertEquals(3000, tuitionfee.getRemainingBalance());
    }

    @Test
    void fullPaidStatusShouldDisplayAsFalse(){
        tuitionfee.calculateTuitionFee(3,0);
        assertEquals(false, tuitionfee.isFullyPaid());
    }

    @Test
    void fullyPaidStatusShouldDisplayAsTrue(){
        tuitionfee.calculateTuitionFee(3,0);
        tuitionfee.makePayment(3000);
        assertEquals(true, tuitionfee.isFullyPaid());
    }
}