package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<Course> courses = new ArrayList();

    public Instructor(int id, String name, ArrayList<Course> courses){
        super(id,name);
        this.courses = courses;
    }
}
