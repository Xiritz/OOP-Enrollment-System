package org.example.model;

public class Payment {
    private String studentId;
    private double totalTuition;
    private double remainingBalance;

    public Payment(String studentId, double totalTuition, double remainingBalance) {
        this.studentId = studentId;
        this.totalTuition = totalTuition;
        this.remainingBalance = remainingBalance;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getTotalTuition() {
        return totalTuition;
    }

    public void setTotalTuition(double totalTuition) {
        this.totalTuition = totalTuition;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
