package org.example.service;
import org.example.model.*;

import java.util.*;

public class StudentServiceImpl implements StudentService {
    List<Student> studentList = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        boolean exists = false;
        for (Student s : studentList) {
            if (s.getId().equals(student.getId())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Student ID already exists!");
        } else {
            studentList.add(student);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public void updateStudent(Student student) {
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                studentList.set(i, student);
                System.out.println("Student record updated in system.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + student.getId() + " not found.");
        }
    }

    @Override
    public void removeStudent(String studentId) {
        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(studentId)) {
                studentList.remove(i);
                System.out.println("Student removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student s : studentList) {
            if (s.getId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
}
