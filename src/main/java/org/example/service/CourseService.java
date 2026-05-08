package org.example.service;

import org.example.model.Course;
import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> getAllCourses();
    void updateCourse(Course course);
    boolean removeCourse(String courseId);
}
