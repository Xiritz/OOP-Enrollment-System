package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        Student s = new Student("1001", "John Doe", "IT1A");
        studentService.saveStudent(s);
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void testSaveStudentDuplicateID() {
        studentService.saveStudent(new Student("1001", "John Doe", "IT1A"));
        studentService.saveStudent(new Student("1001", "Jane Doe", "IT2A"));
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testUpdateStudentInteractive() {
        studentService.saveStudent(new Student("1001", "John Doe", "IT1A"));
        Student s = studentService.getAllStudents().get(0);

        String input = "Bob Smith" + System.lineSeparator() + "IT3A" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        studentService.updateStudent(s);

        Student updated = studentService.getAllStudents().get(0);
        assertEquals("Bob Smith", updated.getName());
        assertEquals("IT3A", updated.getProgram());
    }

    @Test
    void testRemoveStudentSuccess() {
        studentService.saveStudent(new Student("1001", "Jane Doe", "IT2A"));
        studentService.removeStudent("1001");
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void testRemoveStudentNotFound() {
        studentService.removeStudent("9999");
        assertEquals(0, studentService.getAllStudents().size());
    }
}
