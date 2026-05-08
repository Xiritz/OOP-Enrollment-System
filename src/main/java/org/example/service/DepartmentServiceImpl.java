package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentServiceImpl implements DepartmentService {
    private List<Department> departmentList = new ArrayList<>();
    private Scanner scn = new Scanner(System.in);

    @Override
    public void createDepartment(String id, String departmentName) {
        departmentList.add(new Department(id, departmentName));
    }

    @Override
    public void displayDepartment() {
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i));
        }
    }

    @Override
    public void removeDepartment() {
        System.out.print("Enter Department ID to remove: ");
        String id = scn.nextLine();

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
    public void addInstructorToDepartment(String departmentId, Instructor instructor) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(departmentId)) {
                departmentList.get(i).getInstructors().add(instructor);
                break;
            }
        }
    }

    @Override
    public void addCourseToDepartment(String departmentId, Course course) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId().equals(departmentId)) {
                departmentList.get(i).getCourses().add(course);
                break;
            }
        }
    }

}
