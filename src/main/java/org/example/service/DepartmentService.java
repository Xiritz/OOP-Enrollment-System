package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Instructor;
import java.util.List;

public interface DepartmentService {
    void createDepartment(String id, String departmentName);
    List<Department> getAllDepartments();
    void removeDepartment(String id);
    void addInstructorToDepartment(String departmentId, Instructor instructor);
    void addCourseToDepartment(String departmentId, Course course);
}
