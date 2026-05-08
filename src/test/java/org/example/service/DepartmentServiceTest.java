package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentServiceImpl();
    }

    @Test
    void testCreateDepartmentSuccess() {
        departmentService.createDepartment("D001", "CS");
        assertEquals(1, departmentService.getAllDepartments().size());
    }

    @Test
    void testCreateDepartmentDuplicateID() {
        departmentService.createDepartment("D001", "CS");
        departmentService.createDepartment("D001", "IT");
        assertEquals(1, departmentService.getAllDepartments().size());
    }

    @Test
    void testUpdateDepartmentInteractive() {
        departmentService.createDepartment("D001", "Old Name");
        Department d = departmentService.getAllDepartments().get(0);

        String input = "New Name\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        departmentService.updateDepartment(d);

        assertEquals("New Name", departmentService.getAllDepartments().get(0).getDepartmentName());
        System.setIn(System.in);
    }

    @Test
    void testAddInstructorToDepartment() {
        departmentService.createDepartment("D001", "CS");
        Instructor i = new Instructor("I001", "Smith", new ArrayList<>(), new ArrayList<>());
        departmentService.addInstructorToDepartment("D001", i);
        assertTrue(departmentService.getAllDepartments().get(0).getInstructors().contains(i));
    }

    @Test
    void testRemoveDepartmentSuccess() {
        departmentService.createDepartment("D001", "CS");
        departmentService.removeDepartment("D001");
        assertEquals(0, departmentService.getAllDepartments().size());
    }
}
