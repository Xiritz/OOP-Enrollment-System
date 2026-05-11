package org.example.model;

public class Course {

    private String courseID;
    private String courseName;
    private String program;
    private Instructor instructor;
    private Section assignedSection;
    private Course prerequisite;
    private int units;

    public Course(String courseID, String courseName, String program, Instructor instructor, Section assignedSection, Course prerequisite, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
        this.instructor = instructor;
        this.assignedSection = assignedSection;
        this.prerequisite = prerequisite;
        this.units = units;
    }

    public String getCourseID(){
        return courseID;
    }

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Section getAssignedSection() {
        return assignedSection;
    }

    public void setAssignedSection(Section assignedSection) {
        this.assignedSection = assignedSection;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Course prerequisite) {
        this.prerequisite = prerequisite;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void displayCourse(){
        System.out.println("Course ID: " + getCourseID());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Program: " + getProgram());
        System.out.println("Units: " + getUnits());
        if (prerequisite != null) {
            System.out.println("Prerequisite: " + prerequisite.getCourseName());
        }
    }
}
