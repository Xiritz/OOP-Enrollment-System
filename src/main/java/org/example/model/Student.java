package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String program;
    private Section sectionEnrolled;
    private boolean isScholar;
    private List<Course> passedCourses;
    private int unitsEnrolled;

    public Student(String id, String name, String program, Section sectionEnrolled, boolean isScholar, List<Course> passedCourses, int unitsEnrolled) {
        super(id, name);
        this.program = program;
        this.sectionEnrolled = sectionEnrolled;
        this.isScholar = isScholar;
        this.passedCourses = passedCourses;
        this.unitsEnrolled = unitsEnrolled;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program=program;
    }

    public Section getSectionEnrolled(){
        return sectionEnrolled;
    }

    public void setSectionEnrolled(Section section){
        this.sectionEnrolled = section;
    }

    public boolean isScholar() {
        return isScholar;
    }

    public void setScholar(boolean scholar) {
        this.isScholar = scholar;
    }

    public List<Course> getPassedCourses() {
        return passedCourses;
    }

    public void setPassedCourses(List<Course> passedCourses) {
        this.passedCourses = passedCourses;
    }

    public void addPassedCourse(Course course) {
        this.passedCourses.add(course);
    }

    public int getUnitsEnrolled() {
        return unitsEnrolled;
    }

    public void setUnitsEnrolled(int unitsEnrolled) {
        this.unitsEnrolled = unitsEnrolled;
    }

    @Override
    public void mainTask(){
        System.out.println("Studies");
    }
}
