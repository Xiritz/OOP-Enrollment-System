package org.example.service;
import org.example.model.Course;

import java.util.*;

public class CourseServiceImpl implements CourseService {
    List<Course> courses = new ArrayList<>();

    @Override
    public void saveCourse(Course course) {
        boolean exists = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(course.getCourseID())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Course ID already exists!");
        } else {
            courses.add(course);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public void updateCourse(Course course) {
        boolean found = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(course.getCourseID())) {
                courses.set(i, course);
                System.out.println("Course record updated in system.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course with ID " + course.getCourseID() + " not found.");
        }
    }

    @Override
    public boolean removeCourse(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                courses.remove(i);
                System.out.println("Course removed successfully.");
                return true;
            }
        }
        System.out.println("Course not found.");
        return false;
    }
}
