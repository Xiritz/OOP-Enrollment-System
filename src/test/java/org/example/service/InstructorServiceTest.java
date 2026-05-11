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
        instructorService.addInstructor("I001", "Bob Smith", new ArrayList<>());
        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void testAddInstructorDuplicateID() {
        instructorService.addInstructor("I001", "Bob Smith", new ArrayList<>());
        instructorService.addInstructor("I001", "Jane Doe", new ArrayList<>());
        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void testUpdateInstructor() {
        instructorService.addInstructor("I001", "John Doe", new ArrayList<>());
        Instructor updated = new Instructor("I001", "Bob Smith", new ArrayList<>(), new ArrayList<>());

        instructorService.updateInstructor(updated);

        assertEquals("Bob Smith", instructorService.getAllInstructors().get(0).getName());
    }

    @Test
    void testAssignInstructorToCourse() {
        Instructor i = new Instructor("I001", "Bob Smith", new ArrayList<>(), new ArrayList<>());
        Course c = new Course("CS101", "Java", "IT1A", null, null, null, 3);
        instructorService.assignInstructorToCourse(i, c);
        assertEquals(i, c.getInstructor());
        assertTrue(i.getCourses().contains(c));
    }

    @Test
    void testRemoveInstructorSuccess() {
        instructorService.addInstructor("I001", "Bob Smith", new ArrayList<>());
        instructorService.removeInstructor("I001");
        assertEquals(0, instructorService.getAllInstructors().size());
    }
}
