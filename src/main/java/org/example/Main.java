package org.example;

import org.example.model.Course;
import org.example.model.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student p = new Student();
        p.setStudentName("John");
        p.setStudentID("0987654321");
        p.setProgram("BSIT");

        Course c = new Course();
        c.setCourseID("INTEPROG");
        c.setProgram("BSIT/CS");
        c.setCourseName("Integrative Program");


        p.displayStudent();
        System.out.println();
        c.displayCourse();
        ;

    }
}