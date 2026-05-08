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
        Scanner scn = new Scanner(System.in);
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                System.out.print("Enter Name: ");
                String name = scn.nextLine();

                System.out.print("Enter Program: ");
                String program = scn.nextLine();

                studentList.set(i, new Student(student.getId(), name, program));
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
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
}
