package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePaymentServiceImpl tuitionfee;
    private final String STUDENT_ID = "S001";

    @BeforeEach
    void setUp(){
        tuitionfee = new TuitionFeePaymentServiceImpl();
    }

    @Test
    void calculateTutionFee(){
        assertEquals(3000, tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0));
    }

    @Test
    void shouldCalculateTuitionWithDiscountRate(){
        assertEquals(2700, tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0.10));
    }

    @Test
    void balanceShouldUpdate(){
        tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0);
        tuitionfee.makePayment(STUDENT_ID, 500);
        assertEquals(2500, tuitionfee.getRemainingBalance(STUDENT_ID));
    }

    @Test
    void balanceShouldShow(){
        tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0);
        assertEquals(3000, tuitionfee.getRemainingBalance(STUDENT_ID));
    }

    @Test
    void fullPaidStatusShouldDisplayAsFalse(){
        tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0);
        assertEquals(false, tuitionfee.isFullyPaid(STUDENT_ID));
    }

    @Test
    void fullyPaidStatusShouldDisplayAsTrue(){
        tuitionfee.calculateTuitionFee(STUDENT_ID, 3, 0);
        tuitionfee.makePayment(STUDENT_ID, 3000);
        assertEquals(true, tuitionfee.isFullyPaid(STUDENT_ID));
    }
    
    @Test
    void shouldMaintainDistinctBalancesForMultipleStudents() {
        tuitionfee.calculateTuitionFee("1001", 3, 0);
        tuitionfee.calculateTuitionFee("1002", 5, 0.10);

        assertEquals(3000, tuitionfee.getRemainingBalance("1001"), "John Doe's balance should be 3000");
        assertEquals(4500, tuitionfee.getRemainingBalance("1002"), "Jane Doe's balance should be 4500");
    }

    @Test
    void shouldUpdateBalancesIndependentlyAfterPayments() {
        tuitionfee.calculateTuitionFee("1001", 4, 0); // 4000
        tuitionfee.calculateTuitionFee("1002", 4, 0); // 4000

        tuitionfee.makePayment("1001", 1500);
        tuitionfee.makePayment("1002", 3000);

        assertEquals(2500, tuitionfee.getRemainingBalance("1001"), "John's balance should be 2500 after 1500 payment");
        assertEquals(1000, tuitionfee.getRemainingBalance("1002"), "Jane's balance should be 1000 after 3000 payment");
    }

    @Test
    void shouldHandleFullPaymentForOneStudentWhileOthersHaveBalance() {
        tuitionfee.calculateTuitionFee("1001", 2, 0); // 2000
        tuitionfee.calculateTuitionFee("1002", 2, 0); // 2000

        // John pays in full
        tuitionfee.makePayment("1001", 2000);

        assertTrue(tuitionfee.isFullyPaid("1001"), "John should be fully paid");
        assertFalse(tuitionfee.isFullyPaid("1002"), "Jane should still have a balance");
        assertEquals(2000, tuitionfee.getRemainingBalance("1002"));
    }
}
