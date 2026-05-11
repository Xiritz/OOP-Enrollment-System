package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private String departmentName;
    private List<Instructor> instructors;
    private List<Course> courses;
    private List<Section> sections;

    public Department(String id, String departmentName, List<Instructor> instructors, List<Course> courses, List<Section> sections) {
        this.id = id;
        this.departmentName = departmentName;
        this.instructors = instructors;
        this.courses = courses;
        this.sections = sections;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", instructorsCount=" + instructors.size() +
                ", coursesCount=" + courses.size() +
                ", sectionsCount=" + sections.size() +
                '}';
    }
}
