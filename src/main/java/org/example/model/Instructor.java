package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private List<Course> courses = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();

    public Instructor(String id, String name, List<Course> courses, List<Section> sections){
        super(id,name);
        this.courses = courses;
        this.sections = sections;
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
    public void mainTask(){
        System.out.println("Teaches");
    }
}


