package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class InstructorServiceTest {
    private InstructorServiceImpl instructorService;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
    }

    @Test
    void testAddInstructorSuccess() {
        instructorService.addInstructor("I001", "Prof. X", new ArrayList<>());
        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void testAddInstructorDuplicateID() {
        instructorService.addInstructor("I001", "Prof. X", new ArrayList<>());
        instructorService.addInstructor("I001", "Prof. Y", new ArrayList<>());
        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void testUpdateInstructorInteractive() {
        instructorService.addInstructor("I001", "Old Name", new ArrayList<>());
        Instructor i = instructorService.getAllInstructors().get(0);

        String input = "New Name\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        instructorService.updateInstructor(i);

        assertEquals("New Name", instructorService.getAllInstructors().get(0).getName());
        System.setIn(System.in);
    }

    @Test
    void testAssignInstructorToCourse() {
        Instructor i = new Instructor("I001", "Smith", new ArrayList<>(), new ArrayList<>());
        Course c = new Course("CS101", "Java", "BSCS");
        instructorService.assignInstructorToCourse(i, c);
        assertEquals(i, c.getInstructor());
        assertTrue(i.getCourses().contains(c));
    }

    @Test
    void testRemoveInstructorSuccess() {
        instructorService.addInstructor("I001", "Smith", new ArrayList<>());
        instructorService.removeInstructor("I001");
        assertEquals(0, instructorService.getAllInstructors().size());
    }
}
