package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private List<Course> courses;
    private List<Student> enrolledStudents;
    private final int maxCapacity = 30;
    private int currentCapacity = 0;

    public Section(String sectionName, List<Course> courses, List<Student> enrolledStudents, int currentCapacity){
        this.sectionName = sectionName;
        this.courses = courses;
        this.enrolledStudents = enrolledStudents;
        this.currentCapacity = currentCapacity;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public int getCurrentCapacity(){
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity){
        this.currentCapacity = currentCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
