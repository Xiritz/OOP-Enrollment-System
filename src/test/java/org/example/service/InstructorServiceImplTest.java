package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructorServiceImplTest {

    private InstructorServiceImpl instructorService;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
    }

    @Test
    void shouldAddInstructor() {
        String id = "1001";
        String name = "John Doe";
        List<Course> courses = new ArrayList<>();

        assertDoesNotThrow(() -> instructorService.addInstructor(id, name, courses));
    }

    @Test
    void shouldAssignInstructorToCourse() {
        Instructor instructor = new Instructor("1001", "John Doe", new ArrayList<>(), new ArrayList<>());
        Course course = new Course("Coprog1", "Computer Programming", "BSCS");

        instructorService.assignInstructorToCourse(instructor, course);

        assertEquals(instructor, course.getInstructor(), "Course should have the assigned instructor");
        assertTrue(instructor.getCourses().contains(course), "Instructor's course list should contain the course");
    }

    @Test
    void shouldNotDuplicateCourseInInstructorList() {
        Instructor instructor = new Instructor("1001", "John Doe", new ArrayList<>(), new ArrayList<>());
        Course course = new Course("Coprog1", "Computer Programming 1", "BSCS");

        instructorService.assignInstructorToCourse(instructor, course);
        instructorService.assignInstructorToCourse(instructor, course);

        assertEquals(1, instructor.getCourses().size(), "Instructor should not have duplicate courses");
    }
}
