package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private String departmentName;
    private List<Instructor> instructors;
    private List<Course> courses;

    public Department(String id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
        this.instructors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", instructorsCount=" + instructors.size() +
                ", coursesCount=" + courses.size() +
                '}';
    }
}
