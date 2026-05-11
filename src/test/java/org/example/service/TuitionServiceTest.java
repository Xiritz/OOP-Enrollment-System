package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TuitionServiceTest {
    private TuitionFeePaymentServiceImpl tuitionService;

    @BeforeEach
    void setUp() {
        tuitionService = new TuitionFeePaymentServiceImpl();
    }

    @Test
    void testCalculateTuitionSuccess() {
        double fee = tuitionService.calculateTuitionFee("1001", 3, 0);
        assertEquals(3000.0, fee);
        assertEquals(3000.0, tuitionService.getRemainingBalance("1001"));
    }

    @Test
    void testCalculateTuitionWithDiscount() {
        double fee = tuitionService.calculateTuitionFee("1001", 3, 0.10);
        assertEquals(2700.0, fee);
    }

    @Test
    void testMakePaymentSuccess() {
        tuitionService.calculateTuitionFee("1001", 3, 0);
        tuitionService.makePayment("1001", 1000.0);
        assertEquals(2000.0, tuitionService.getRemainingBalance("1001"));
    }

    @Test
    void testRejectNegativePayment() {
        tuitionService.calculateTuitionFee("1001", 3, 0);
        tuitionService.makePayment("1001", -500.0);
        assertEquals(3000.0, tuitionService.getRemainingBalance("1001"));
    }

    @Test
    void testRejectOverpayment() {
        tuitionService.calculateTuitionFee("1001", 3, 0);
        tuitionService.makePayment("1001", 5000.0);
        assertEquals(3000.0, tuitionService.getRemainingBalance("1001"));
    }

    @Test
    void testMultiStudentIsolation() {
        tuitionService.calculateTuitionFee("1001", 3, 0);
        tuitionService.calculateTuitionFee("1002", 5, 0);
        
        tuitionService.makePayment("1001", 1000.0);
        
        assertEquals(2000.0, tuitionService.getRemainingBalance("1001"));
        assertEquals(5000.0, tuitionService.getRemainingBalance("1002"));
    }

    @Test
    void testFullPaymentStatus() {
        tuitionService.calculateTuitionFee("1001", 1, 0);
        tuitionService.makePayment("1001", 1000.0);
        assertTrue(tuitionService.isFullyPaid("1001"));
    }
}
