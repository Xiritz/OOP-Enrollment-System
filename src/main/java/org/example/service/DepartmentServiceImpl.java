package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void createDepartment(String id, String departmentName) {
        boolean exists = false;
        for (Department dept : departmentList) {
            if (dept.getId().equals(id)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Department ID already exists!");
        } else {
            departmentList.add(new Department(id, departmentName));
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentList;
    }

    @Override
    public void removeDepartment(String id) {
        boolean removed = false;
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(id)) {
                departmentList.remove(i);
                System.out.println("Department removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void updateDepartment(Department department) {
        java.util.Scanner scn = new java.util.Scanner(System.in);
        boolean found = false;
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(department.getId())) {
                System.out.print("Enter New Department Name: ");
                String name = scn.nextLine();
                
                departmentList.get(i).setDepartmentName(name);
                System.out.println("Department updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void addInstructorToDepartment(String departmentId, Instructor instructor) {
        boolean found = false;
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(departmentId)) {
                departmentList.get(i).getInstructors().add(instructor);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Department not found: " + departmentId);
        }
    }

    @Override
    public void addCourseToDepartment(String departmentId, Course course) {
        boolean found = false;
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(departmentId)) {
                departmentList.get(i).getCourses().add(course);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Department not found: " + departmentId);
        }
    }

}
