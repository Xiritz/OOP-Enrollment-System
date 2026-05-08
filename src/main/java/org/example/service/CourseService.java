package org.example.service;

import org.example.model.Course;

public interface CourseService {
        void save();
        void display();
        void updateCourse(Course course);
        void removeCourse();
}
