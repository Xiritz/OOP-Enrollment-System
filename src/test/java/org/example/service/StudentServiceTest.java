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
        Student s = new Student("1001", "John Doe", "BSCS");
        studentService.saveStudent(s);
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void testSaveStudentDuplicateID() {
        studentService.saveStudent(new Student("1001", "John", "BSCS"));
        studentService.saveStudent(new Student("1001", "Jane", "BSIT"));
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testUpdateStudentInteractive() {
        studentService.saveStudent(new Student("1001", "Old Name", "Old Program"));
        Student s = studentService.getAllStudents().get(0);

        String input = "New Name" + System.lineSeparator() + "New Program" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        studentService.updateStudent(s);

        Student updated = studentService.getAllStudents().get(0);
        assertEquals("New Name", updated.getName());
        assertEquals("New Program", updated.getProgram());
    }

    @Test
    void testRemoveStudentSuccess() {
        studentService.saveStudent(new Student("1001", "John", "BSCS"));
        studentService.removeStudent("1001");
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void testRemoveStudentNotFound() {
        studentService.removeStudent("9999");
        assertEquals(0, studentService.getAllStudents().size());
    }
}
