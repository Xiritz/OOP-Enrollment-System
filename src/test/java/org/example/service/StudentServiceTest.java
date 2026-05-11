package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentServiceImpl studentService;
    private static InputStream trueOriginalIn;

    @BeforeAll
    static void saveOriginalIn() {
        trueOriginalIn = System.in;
    }

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
        System.setIn(trueOriginalIn);
    }

    @AfterEach
    void tearDown() {
        System.setIn(trueOriginalIn);
    }

    @Test
    void testSaveStudentSuccess() {
        Student s = new Student("1001", "John Doe", "IT1A", null, false, new ArrayList<>(), 0);
        studentService.saveStudent(s);
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void testSaveStudentDuplicateID() {
        studentService.saveStudent(new Student("1001", "John Doe", "IT1A", null, false, new ArrayList<>(), 0));
        studentService.saveStudent(new Student("1001", "Jane Doe", "IT2A", null, false, new ArrayList<>(), 0));
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void testUpdateStudent() {
        studentService.saveStudent(new Student("1001", "John Doe", "IT1A", null, false, new ArrayList<>(), 0));
        Student updated = new Student("1001", "Bob Smith", "IT3A", null, true, new ArrayList<>(), 0);

        studentService.updateStudent(updated);

        Student result = studentService.getAllStudents().get(0);
        assertEquals("Bob Smith", result.getName());
        assertEquals("IT3A", result.getProgram());
        assertTrue(result.isScholar());
    }

    @Test
    void testRemoveStudentSuccess() {
        studentService.saveStudent(new Student("1001", "Jane Doe", "IT2A", null, false, new ArrayList<>(), 0));
        studentService.removeStudent("1001");
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void testRemoveStudentNotFound() {
        studentService.removeStudent("9999");
        assertEquals(0, studentService.getAllStudents().size());
    }
}
