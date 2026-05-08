package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
    }

    @Test
    void testSaveCourseSuccess() {
        courseService.saveCourse(new Course("CS101", "Java", "BSCS"));
        assertEquals(1, courseService.getAllCourses().size());
    }

    @Test
    void testSaveCourseDuplicateID() {
        courseService.saveCourse(new Course("CS101", "Java", "BSCS"));
        courseService.saveCourse(new Course("CS101", "Python", "BSIT"));
        assertEquals(1, courseService.getAllCourses().size());
    }

    @Test
    void testUpdateCourseInteractive() {
        courseService.saveCourse(new Course("CS101", "Old Title", "Old Program"));
        Course c = courseService.getAllCourses().get(0);

        String input = "New Title\nNew Program\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        courseService.updateCourse(c);

        assertEquals("New Title", courseService.getAllCourses().get(0).getCourseName());
        System.setIn(System.in);
    }

    @Test
    void testRemoveCourseSuccess() {
        courseService.saveCourse(new Course("CS101", "Java", "BSCS"));
        boolean result = courseService.removeCourse("CS101");
        assertTrue(result);
        assertEquals(0, courseService.getAllCourses().size());
    }
}
