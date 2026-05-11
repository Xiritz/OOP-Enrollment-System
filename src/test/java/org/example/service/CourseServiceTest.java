package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
    }

    @Test
    void testSaveCourseSuccess() {
        courseService.saveCourse(new Course("CS101", "Java", "IT1A", null, null, null, 3));
        assertEquals(1, courseService.getAllCourses().size());
    }

    @Test
    void testSaveCourseDuplicateID() {
        courseService.saveCourse(new Course("CS101", "Java", "IT1A", null, null, null, 3));
        courseService.saveCourse(new Course("CS101", "Python", "IT2A", null, null, null, 3));
        assertEquals(1, courseService.getAllCourses().size());
    }

    @Test
    void testUpdateCourse() {
        courseService.saveCourse(new Course("CS101", "Old Title", "IT1A", null, null, null, 3));
        Course updated = new Course("CS101", "New Title", "IT2A", null, null, null, 4);

        courseService.updateCourse(updated);

        assertEquals("New Title", courseService.getAllCourses().get(0).getCourseName());
        assertEquals(4, courseService.getAllCourses().get(0).getUnits());
    }

    @Test
    void testRemoveCourseSuccess() {
        courseService.saveCourse(new Course("CS101", "Java", "IT1A", null, null, null, 3));
        boolean result = courseService.removeCourse("CS101");
        assertTrue(result);
        assertEquals(0, courseService.getAllCourses().size());
    }
}
