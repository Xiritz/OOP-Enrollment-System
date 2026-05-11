package org.example.service;

import org.example.model.*;

import java.util.List;

public class CampusRegistrar {
    private StudentService studentService;
    private CourseService courseReg;
    private InstructorService instructorService;
    private SectionService sectionService;
    private DepartmentService departmentService;
    private TuitionFeePaymentService tuitionService;

    public CampusRegistrar(StudentService studentReg, CourseService courseReg, InstructorService instructorServ, SectionService secService, DepartmentService deptService, TuitionFeePaymentService tuitionServ){
        this.studentService = studentReg;
        this.courseReg = courseReg;
        this.instructorService = instructorServ;
        this.sectionService = secService;
        this.departmentService = deptService;
        this.tuitionService = tuitionServ;
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
    public Student getStudentById(String studentId){
        return studentService.getStudentById(studentId);
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
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }
    public void removeInstructor(String id){
        instructorService.removeInstructor(id);
    }
    public void assignInstructorToCourse(Instructor instructor, Course course){
        instructorService.assignInstructorToCourse(instructor,course);
    }
    public void getInstructorDetails(Instructor instructor){
        instructorService.getInstructorDetails(instructor);
    }
    public void updateInstructor(Instructor instructor){
        instructorService.updateInstructor(instructor);
    }

    public void addSection(Section section){
        sectionService.addSection(section);
    }
    public void deleteSection(String sectionName){
        sectionService.deleteSection(sectionName);
    }
    public void updateSection(Section section){
        sectionService.updateSection(section);
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
    public void updateDepartment(Department department){
        departmentService.updateDepartment(department);
    }
    public void addInstructorToDepartment(String departmentId, Instructor instructor) {
        departmentService.addInstructorToDepartment(departmentId, instructor);
    }
    public void addCourseToDepartment(String departmentId, Course course) {
        departmentService.addCourseToDepartment(departmentId, course);
    }
    public void addSectionToDepartment(String departmentId, Section section) {
        departmentService.addSectionToDepartment(departmentId, section);
    }

    public double calculateTuitionFee(String studentId, double discountRate) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return 0;
        }
        return tuitionService.calculateTuitionFee(studentId, student.getUnitsEnrolled(), discountRate);
    }
    public void makePayment(String studentId, double amount) {
        tuitionService.makePayment(studentId, amount);
    }
    public double getRemainingBalance(String studentId) {
        return tuitionService.getRemainingBalance(studentId);
    }
    public boolean isFullyPaid(String studentId) {
        return tuitionService.isFullyPaid(studentId);
    }
}
