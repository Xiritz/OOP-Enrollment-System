package org.example.service;

import org.example.model.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void removeStudent(String studentId);
}
