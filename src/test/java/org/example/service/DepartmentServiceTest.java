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
        departmentService.createDepartment("D001", "CCS");
        assertEquals(1, departmentService.getAllDepartments().size());
    }

    @Test
    void testCreateDepartmentDuplicateID() {
        departmentService.createDepartment("D001", "CCS");
        departmentService.createDepartment("D001", "CBA");
        assertEquals(1, departmentService.getAllDepartments().size());
    }

    @Test
    void testUpdateDepartment() {
        departmentService.createDepartment("D001", "Old Name");
        Department updated = new Department("D001", "New Name", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        departmentService.updateDepartment(updated);

        assertEquals("New Name", departmentService.getAllDepartments().get(0).getDepartmentName());
    }

    @Test
    void testAddInstructorToDepartment() {
        departmentService.createDepartment("D001", "CCS");
        Instructor i = new Instructor("I001", "Bob Smith", new ArrayList<>(), new ArrayList<>());
        departmentService.addInstructorToDepartment("D001", i);
        assertTrue(departmentService.getAllDepartments().get(0).getInstructors().contains(i));
    }

    @Test
    void testRemoveDepartmentSuccess() {
        departmentService.createDepartment("D001", "CCS");
        departmentService.removeDepartment("D001");
        assertEquals(0, departmentService.getAllDepartments().size());
    }
}
