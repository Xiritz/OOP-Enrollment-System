package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;

import java.util.List;

public class CampusRegistrar {
    private StudentService studentService;
    private CourseService courseReg;
    private InstructorService instructorService;
    private SectionService sectionService;
    public CampusRegistrar(StudentService studentReg, CourseService courseReg, InstructorService instructorServ, SectionService secService){
        this.studentService = studentReg;
        this.courseReg = courseReg;
    }

    public void saveStudent(Student student){
        studentService.saveStudent(student);
    }
    public void displayAllStudent(){
        studentService.displayAllStudent();
    }
    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }
    public void removeStudent(Student student){
        studentService.updateStudent(student);
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

    public void addInstrutor(String id, String name, List<Course> courses){
        instructorService.addInstructor(id, name, courses);
    }
    public void assignInstructorToCourse(Instructor instructor, Course course){
        instructorService.assignInstructorToCourse(instructor,course);
    }
    public void getInstructorDetails(Instructor instructor){
        instructorService.getInstructorDetails(instructor);
    }

    public void addSection(String name, Course course){
        sectionService.addSection(name, course);
    }
    public void deleteSection(int sectionIndex){
        sectionService.deleteSection(sectionIndex);
    }
    public void assignStudentToSection(Student student, Section section){
        sectionService.assignStudentToSection(student, section);
    }
    public void assignCourseToSection(Course course, Section section) {
        sectionService.assignCourseToSection(course, section);
    }
    public void getSectionDetails(){
        sectionService.getSectionDetails();
    }
}
