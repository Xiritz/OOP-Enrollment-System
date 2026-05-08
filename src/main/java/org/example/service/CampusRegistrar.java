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
    private DepartmentService departmentService;

    public CampusRegistrar(StudentService studentReg, CourseService courseReg, InstructorService instructorServ, SectionService secService, DepartmentService deptService){
        this.studentService = studentReg;
        this.courseReg = courseReg;
        this.instructorService = instructorServ;
        this.sectionService = secService;
        this.departmentService = deptService;
    }

    public void saveStudent(Student student){
        studentService.saveStudent(student);
    }
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }
    public void removeStudent(String studentId){
        studentService.removeStudent(studentId);
    }

    public void saveCourse(Course course){
        courseReg.saveCourse(course);
    }
    public List<Course> getAllCourses(){
        return courseReg.getAllCourses();
    }
    public void updateCourse(Course course){
        courseReg.updateCourse(course);
    }
    public void removeCourse(String courseId){
        courseReg.removeCourse(courseId);
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

    public void addSection(Section section){
        sectionService.addSection(section);
    }
    public void deleteSection(String sectionName){
        sectionService.deleteSection(sectionName);
    }
    public void assignStudentToSection(Student student, Section section){
        sectionService.assignStudentToSection(student, section);
    }
    public void assignCourseToSection(Course course, Section section) {
        sectionService.assignCourseToSection(course, section);
    }
    public List<Section> getAllSections(){
        return sectionService.getAllSections();
    }

    public void createDepartment(String id, String departmentName) {
        departmentService.createDepartment(id, departmentName);
    }
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    public void removeDepartment(String id) {
        departmentService.removeDepartment(id);
    }
    public void addInstructorToDepartment(String departmentId, Instructor instructor) {
        departmentService.addInstructorToDepartment(departmentId, instructor);
    }
    public void addCourseToDepartment(String departmentId, Course course) {
        departmentService.addCourseToDepartment(departmentId, course);
    }
}
