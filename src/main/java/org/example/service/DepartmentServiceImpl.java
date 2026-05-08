package org.example.service;

import org.example.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void createDepartment(String id, String departmentName) {
        departmentList.add(new Department(id, departmentName));
    }

    @Override
    public void displayDepartment() {
 
    }

    @Override
    public void removeDepartment() {

    }

}
