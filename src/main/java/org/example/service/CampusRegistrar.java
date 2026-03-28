package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistration studentReg;
    private CourseRegistration courseReg;

    public CampusRegistrar(StudentRegistration studentReg, CourseRegistration courseReg) {
        this.studentReg = studentReg;
        this.courseReg = courseReg;
    }

    public void saveStudent(Student student){
        studentReg.saveStudent(student);
    }
    public void displayAllStudent(){
        studentReg.displayAllStudent();
    }
    public void updateStudent(Student student){
        studentReg.updateStudent(student);
    }
    public void removeStudent(Student student){
        studentReg.updateStudent(student);
    }

    public void save(){
        courseReg.save();
    }
    public void display(){
        courseReg.display();
    }
    public void updateCourse(Course course){
        courseReg.updateCourse(course);
    }
    public void removeCourse(){
        courseReg.removeCourse();
    }
}
