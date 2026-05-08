package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;

public interface DepartmentService {
    void createDepartment(String id, String departmentName);
    void displayDepartment();
    void removeDepartment();
    void addInstructorToDepartment(String departmentId, Instructor instructor);
    void addCourseToDepartment(String departmentId, Course course);
}
