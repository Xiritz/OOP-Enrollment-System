package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.*;


// Sorry po sir if gumamit na po ako ng ai para sa integration po ng mga services naubusan lang
// po ng oras sa pag cocode po ng final project po namin for system analysis and design
// Thank you po sir for this semester madami po ako natutunan
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CampusRegistrar registrar;

    public static void main(String[] args) {
        // Initializing all services
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        SectionService sectionService = new SectionServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        TuitionFeePaymentService tuitionService = new TuitionFeePaymentServiceImpl();

        // Injecting services into the Registrar Facade
        registrar = new CampusRegistrar(studentService, courseService, instructorService, sectionService, departmentService, tuitionService);

        createPlaceHolderData();

        boolean isRunning = true;

        System.out.println("=========================================");
        System.out.println("         OOP CAPSTONE PROJECT            ");
        System.out.println("=========================================");

        while (isRunning) {
            System.out.println("\nMAIN MENU:");
            System.out.println("[1] Manage Students");
            System.out.println("[2] Manage Courses");
            System.out.println("[3] Manage Instructors");
            System.out.println("[4] Manage Departments & Sections");
            System.out.println("[5] Enrollment Operations");
            System.out.println("[6] Tuition & Payments");
            System.out.println("[7] View Institutional Hierarchy");
            System.out.println("[8] Exit");
            System.out.print("Please enter your choice: ");

            String input = scanner.nextLine();
            int choice = 0;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number from 1 to 8.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleStudentMenu();
                    break;
                case 2:
                    handleCourseMenu();
                    break;
                case 3:
                    handleInstructorMenu();
                    break;
                case 4:
                    handleDeptSectionMenu();
                    break;
                case 5:
                    handleEnrollmentMenu();
                    break;
                case 6:
                    handleTuitionMenu();
                    break;
                case 7:
                    handleHierarchyView();
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void handleStudentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("[1] Register New Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Update Student Info");
            System.out.println("[4] Remove Student");
            System.out.println("[5] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Program: ");
                    String program = scanner.nextLine();
                    System.out.print("Is this student a scholar? (yes/no): ");
                    boolean isScholar = scanner.nextLine().equalsIgnoreCase("yes");
                    
                    Student newStudent = new Student(id, name, program, null, isScholar, new ArrayList<>(), 0);
                    registrar.saveStudent(newStudent);
                    System.out.println("Student registered successfully.");
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    displayAllStudents();
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();
                    
                    Student existing = registrar.getStudentById(updateId);
                    if (existing != null) {
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Program: ");
                        String newProg = scanner.nextLine();
                        System.out.print("Is this student a scholar? (yes/no): ");
                        boolean isSchol = scanner.nextLine().equalsIgnoreCase("yes");
                        
                        Student updatedStu = new Student(updateId, newName, newProg, existing.getSectionEnrolled(), isSchol, existing.getPassedCourses(), existing.getUnitsEnrolled());
                        registrar.updateStudent(updatedStu);
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    displayAllStudents();
                    System.out.print("Enter Student ID to remove: ");
                    String removeId = scanner.nextLine();
                    registrar.removeStudent(removeId);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    private static void displayAllStudents() {
        List<Student> students = registrar.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- STUDENT LIST ---");
            for (Student s : students) {
                String scholarStatus = s.isScholar() ? "Yes" : "No";
                System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Program: " + s.getProgram() + " | Scholar: " + scholarStatus + " | Units Enrolled: " + s.getUnitsEnrolled());
            }
        }
    }

    private static void handleCourseMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- COURSE MANAGEMENT ---");
            System.out.println("[1] Add New Course");
            System.out.println("[2] View Course Catalog");
            System.out.println("[3] Update Course");
            System.out.println("[4] Remove Course");
            System.out.println("[5] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String cid = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Program: ");
                    String prog = scanner.nextLine();
                    System.out.print("Enter Units: ");
                    int units = 0;
                    try {
                        units = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid unit format. Using 0.");
                    }
                    
                    Course preReq = null;
                    System.out.print("Does this course have a prerequisite? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        displayAllCourses();
                        System.out.print("Enter Prerequisite Course ID: ");
                        String preId = scanner.nextLine();
                        for (Course c : registrar.getAllCourses()) {
                            if (c.getCourseID().equals(preId)) {
                                preReq = c;
                                break;
                            }
                        }
                    }
                    
                    Course newCourse = new Course(cid, title, prog, null, null, preReq, units);
                    registrar.saveCourse(newCourse);
                    System.out.println("Course added.");
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    displayAllCourses();
                    System.out.print("Enter Course ID to update: ");
                    String ucid = scanner.nextLine();
                    
                    Course existingC = null;
                    for (Course c : registrar.getAllCourses()) if (c.getCourseID().equals(ucid)) existingC = c;
                    
                    if (existingC != null) {
                        System.out.print("Enter New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Program: ");
                        String newProgC = scanner.nextLine();
                        System.out.print("Enter New Units: ");
                        int newUnits = 0;
                        try {
                            newUnits = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid format. Using 0.");
                        }
                        
                        Course updatedC = new Course(ucid, newTitle, newProgC, existingC.getInstructor(), existingC.getAssignedSection(), existingC.getPrerequisite(), newUnits);
                        
                        System.out.print("Set new prerequisite? (yes/no): ");
                        if (scanner.nextLine().equalsIgnoreCase("yes")) {
                            displayAllCourses();
                            System.out.print("Enter Prerequisite Course ID: ");
                            String pId = scanner.nextLine();
                            for (Course c : registrar.getAllCourses()) {
                                if (c.getCourseID().equals(pId)) {
                                    updatedC.setPrerequisite(c);
                                    break;
                                }
                            }
                        }
                        
                        registrar.updateCourse(updatedC);
                        System.out.println("Course updated successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    displayAllCourses();
                    System.out.print("Enter Course ID to remove: ");
                    String rcid = scanner.nextLine();
                    registrar.removeCourse(rcid);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    private static void displayAllCourses() {
        List<Course> courses = registrar.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            System.out.println("\n--- COURSE CATALOG ---");
            for (Course c : courses) {
                c.displayCourse();
                System.out.println("-----------------");
            }
        }
    }

    private static void handleInstructorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- INSTRUCTOR MANAGEMENT ---");
            System.out.println("[1] Add Instructor");
            System.out.println("[2] View All Instructors");
            System.out.println("[3] Update Instructor");
            System.out.println("[4] Remove Instructor");
            System.out.println("[5] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String iid = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String iname = scanner.nextLine();
                    registrar.addInstrutor(iid, iname, new ArrayList<>());
                    System.out.println("Instructor added.");
                    break;
                case 2:
                    displayAllInstructors();
                    break;
                case 3:
                    displayAllInstructors();
                    System.out.print("Enter Instructor ID to update: ");
                    String uiid = scanner.nextLine();
                    
                    Instructor existingI = null;
                    for (Instructor i : registrar.getAllInstructors()) if (i.getId().equals(uiid)) existingI = i;
                    
                    if (existingI != null) {
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        Instructor updatedI = new Instructor(uiid, newName, existingI.getCourses(), existingI.getSections());
                        registrar.updateInstructor(updatedI);
                    } else {
                        System.out.println("Instructor not found.");
                    }
                    break;
                case 4:
                    displayAllInstructors();
                    System.out.print("Enter Instructor ID to remove: ");
                    String riid = scanner.nextLine();
                    registrar.removeInstructor(riid);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    private static void displayAllInstructors() {
        List<Instructor> instructors = registrar.getAllInstructors();
        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
        } else {
            System.out.println("\n--- INSTRUCTOR LIST ---");
            for (Instructor i : instructors) {
                System.out.println("ID: " + i.getId() + " | Name: " + i.getName());
            }
        }
    }

    private static void handleDeptSectionMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- DEPARTMENTS & SECTIONS ---");
            System.out.println("[1] Create Department");
            System.out.println("[2] View Departments");
            System.out.println("[3] Create Section");
            System.out.println("[4] View All Sections");
            System.out.println("[5] Add Section to Department");
            System.out.println("[6] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Dept ID: ");
                    String did = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = scanner.nextLine();
                    registrar.createDepartment(did, dname);
                    System.out.println("Department created.");
                    break;
                case 2:
                    displayAllDepartments();
                    break;
                case 3:
                    System.out.print("Enter Section Name (e.g., IT1A): ");
                    String sname = scanner.nextLine();
                    registrar.addSection(new Section(sname, new ArrayList<>(), new ArrayList<>(), 0));
                    System.out.println("Section created.");
                    break;
                case 4:
                    displayAllSections();
                    break;
                case 5:
                    displayAllDepartments();
                    System.out.print("Enter Dept ID: ");
                    String deptId = scanner.nextLine();
                    
                    displayAllSections();
                    System.out.print("Enter Section Name: ");
                    String sectionName = scanner.nextLine();
                    
                    Section foundSec = null;
                    for (Section s : registrar.getAllSections()) {
                        if (s.getSectionName().equals(sectionName)) {
                            foundSec = s;
                            break;
                        }
                    }
                    if (foundSec != null) {
                        registrar.addSectionToDepartment(deptId, foundSec);
                        System.out.println("Linked successfully.");
                    } else {
                        System.out.println("Section not found.");
                    }
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }

    private static void displayAllDepartments() {
        List<Department> depts = registrar.getAllDepartments();
        if (depts.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("\n--- DEPARTMENT LIST ---");
            for (Department d : depts) {
                System.out.println(d);
            }
        }
    }

    private static void displayAllSections() {
        List<Section> sections = registrar.getAllSections();
        if (sections.isEmpty()) {
            System.out.println("No sections found.");
        } else {
            System.out.println("\n--- SECTION LIST ---");
            for (Section s : sections) {
                System.out.println("Section: " + s.getSectionName() + " | Capacity: " + s.getCurrentCapacity() + "/30");
            }
        }
    }

    private static void handleEnrollmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ENROLLMENT & ASSIGNMENTS ---");
            System.out.println("[1] Assign Instructor to Course");
            System.out.println("[2] Assign Course to Section");
            System.out.println("[3] Enroll Student in Section (Block)");
            System.out.println("[4] Set Course Prerequisite");
            System.out.println("[5] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllInstructors();
                    System.out.print("Enter Instructor ID: ");
                    String iid = scanner.nextLine();
                    
                    displayAllCourses();
                    System.out.print("Enter Course ID: ");
                    String cid = scanner.nextLine();
                    
                    Instructor inst = null;
                    for (Instructor i : registrar.getAllInstructors()) if (i.getId().equals(iid)) inst = i;
                    
                    Course crs = null;
                    for (Course c : registrar.getAllCourses()) if (c.getCourseID().equals(cid)) crs = c;
                    
                    if (inst != null && crs != null) {
                        registrar.assignInstructorToCourse(inst, crs);
                        System.out.println("Assigned.");
                    } else {
                        System.out.println("Instructor or Course not found.");
                    }
                    break;
                case 2:
                    displayAllCourses();
                    System.out.print("Enter Course ID: ");
                    String cid2 = scanner.nextLine();
                    
                    displayAllSections();
                    System.out.print("Enter Section Name: ");
                    String sname = scanner.nextLine();
                    
                    Course crs2 = null;
                    for (Course c : registrar.getAllCourses()) if (c.getCourseID().equals(cid2)) crs2 = c;
                    
                    Section sec = null;
                    for (Section s : registrar.getAllSections()) if (s.getSectionName().equals(sname)) sec = s;
                    
                    if (crs2 != null && sec != null) {
                        registrar.assignCourseToSection(crs2, sec);
                        System.out.println("Linked.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                case 3:
                    displayAllStudents();
                    System.out.print("Enter Student ID: ");
                    String sid = scanner.nextLine();
                    
                    displayAllSections();
                    System.out.print("Enter Section Name: ");
                    String sname2 = scanner.nextLine();
                    
                    Student stu = null;
                    for (Student s : registrar.getAllStudents()) if (s.getId().equals(sid)) stu = s;
                    
                    Section sec2 = null;
                    for (Section s : registrar.getAllSections()) if (s.getSectionName().equals(sname2)) sec2 = s;
                    
                    if (stu != null && sec2 != null) {
                        registrar.assignStudentToSection(stu, sec2);
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                case 4:
                    displayAllCourses();
                    System.out.print("Enter Course ID to set prerequisite for: ");
                    String targetId = scanner.nextLine();
                    System.out.print("Enter Prerequisite Course ID: ");
                    String preReqId = scanner.nextLine();
                    
                    Course target = null;
                    Course pre = null;
                    for (Course c : registrar.getAllCourses()) {
                        if (c.getCourseID().equals(targetId)) target = c;
                        if (c.getCourseID().equals(preReqId)) pre = c;
                    }
                    
                    if (target != null && pre != null) {
                        target.setPrerequisite(pre);
                        System.out.println("Prerequisite set.");
                    } else {
                        System.out.println("Courses not found.");
                    }
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    private static void handleTuitionMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- TUITION & PAYMENTS ---");
            System.out.println("[1] Calculate Student Tuition");
            System.out.println("[2] Make Payment");
            System.out.println("[3] View Remaining Balance");
            System.out.println("[4] Back to Main Menu");
            System.out.print("Choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllStudents();
                    System.out.print("Enter Student ID: ");
                    String sid = scanner.nextLine();
                    Student stuForTuition = registrar.getStudentById(sid);
                    
                    double disc = 0;
                    if (stuForTuition != null && stuForTuition.isScholar()) {
                        System.out.println("Student is a scholar! Automatic 100% discount applied.");
                        disc = 1.0;
                    } else {
                        System.out.print("Enter Discount Rate (e.g., 0.1 for 10%): ");
                        try {
                            disc = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Using 0.");
                        }
                    }
                    double total = registrar.calculateTuitionFee(sid, disc);
                    System.out.println("Total calculated: " + total);
                    break;
                case 2:
                    displayAllStudents();
                    System.out.print("Enter Student ID: ");
                    String sid2 = scanner.nextLine();
                    System.out.print("Enter Payment Amount: ");
                    double amount = 0;
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount.");
                        continue;
                    }
                    registrar.makePayment(sid2, amount);
                    break;
                case 3:
                    displayAllStudents();
                    System.out.print("Enter Student ID: ");
                    String sid3 = scanner.nextLine();
                    double bal = registrar.getRemainingBalance(sid3);
                    System.out.println("Remaining Balance: " + bal);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }

    private static void handleHierarchyView() {
        System.out.println("\n--- INSTITUTIONAL HIERARCHY ---");
        displayAllDepartments();
        System.out.print("Enter Department ID to view: ");
        String deptId = scanner.nextLine();
        
        Department found = null;
        for (Department d : registrar.getAllDepartments()) {
            if (d.getId().equals(deptId)) {
                found = d;
                break;
            }
        }
        
        if (found == null) {
            System.out.println("Department not found.");
            return;
        }
        
        System.out.println("\nDepartment: " + found.getDepartmentName());
        if (found.getSections().isEmpty()) {
            System.out.println("  No sections assigned to this department.");
        } else {
            for (Section s : found.getSections()) {
                System.out.println("  Section: " + s.getSectionName());
                System.out.print("    Courses: ");
                if (s.getCourses().isEmpty()) System.out.print("None");
                else {
                    for (Course c : s.getCourses()) {
                        System.out.print(c.getCourseName() + " (Inst: " + (c.getInstructor() != null ? c.getInstructor().getName() : "TBA") + "), ");
                    }
                }
                System.out.println("\n    Enrolled Students: ");
                if (s.getEnrolledStudents().isEmpty()) System.out.println("      None");
                else {
                    for (Student stu : s.getEnrolledStudents()) {
                        System.out.println("      - " + stu.getName() + " (ID: " + stu.getId() + ")");
                    }
                }
            }
        }
    }

    private static void createPlaceHolderData() {
        // 1. Create Courses
        Course javaCourse = new Course("CS101", "Java Programming", "BSCS", null, null, null, 3);
        Course pythonCourse = new Course("CS102", "Python Programming", "BSCS", null, null, null, 3);
        Course dbCourse = new Course("CS201", "Database Systems", "BSCS", null, null, null, 3);
        
        registrar.saveCourse(javaCourse);
        registrar.saveCourse(pythonCourse);
        registrar.saveCourse(dbCourse);
        
        // 2. Create Instructors
        registrar.addInstrutor("I001", "Dr. Alan Turing", new ArrayList<>());
        registrar.addInstrutor("I002", "Grace Hopper", new ArrayList<>());
        
        // 3. Create Sections
        Section cs1a = new Section("CS1A", new ArrayList<>(), new ArrayList<>(), 0);
        Section cs1b = new Section("CS1B", new ArrayList<>(), new ArrayList<>(), 0);
        registrar.addSection(cs1a);
        registrar.addSection(cs1b);
        
        // 4. Create Departments
        registrar.createDepartment("D001", "Computer Science");
        registrar.createDepartment("D002", "Information Technology");
        
        // 5. Create Students
        Student s1 = new Student("2026-001", "Alice Smith", "BSCS", null, false, new ArrayList<>(), 0);
        Student s2 = new Student("2026-002", "Bob Jones", "BSIT", null, true, new ArrayList<>(), 0);
        registrar.saveStudent(s1);
        registrar.saveStudent(s2);

        // 6. Link Entities
        // Add sections to departments
        registrar.addSectionToDepartment("D001", cs1a);
        registrar.addSectionToDepartment("D001", cs1b);
        
        // Assign instructors to courses
        Instructor turing = null;
        for (Instructor i : registrar.getAllInstructors()) if (i.getId().equals("I001")) turing = i;
        if (turing != null) registrar.assignInstructorToCourse(turing, javaCourse);
        
        // Assign courses to sections
        registrar.assignCourseToSection(javaCourse, cs1a);
        registrar.assignCourseToSection(pythonCourse, cs1a);
        
        // Enroll students in sections
        registrar.assignStudentToSection(s1, cs1a);
        registrar.assignStudentToSection(s2, cs1b);

        System.out.println("\nPlaceholder data created successfully.");
    }
}
