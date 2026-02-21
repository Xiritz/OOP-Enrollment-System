package org.example.model;

public class Student {
    private String studentID, studentName, program;

    public Student(){

    }
    public Student(String studentID, String studentName, String program){
        this.studentID = studentID;
        this.studentName = studentName;
        this.program = program;
    }

    public String getStudentID(){
        return studentID;
    }

    public void setStudentID(String studentID){
        this.studentID=studentID;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName=studentName;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program=program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", program='" + program + '\'' +
                '}';
    }

    public void displayStudent(){
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Student Program: " + getProgram());
    }
}
