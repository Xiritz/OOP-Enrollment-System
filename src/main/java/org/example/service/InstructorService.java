package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import java.util.List;

public interface InstructorService {
    void addInstructor(String id, String name, List<Course> courses);
    List<Instructor> getAllInstructors();
    void removeInstructor(String id);
    void assignInstructorToCourse(Instructor instructor, Course course);
    void updateInstructor(Instructor instructor);
    void getInstructorDetails(Instructor instructor);
}
