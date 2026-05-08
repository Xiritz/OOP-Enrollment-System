package org.example.service;

import org.example.model.*;

import java.util.*;

public interface InstructorService {
    void addInstructor(String id, String name, List<Course> courses);
    void assignInstructorToCourse(Instructor instructor, Course course);
    void getInstructorDetails(Instructor instructor);
}
