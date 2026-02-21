package org.example.service;
import org.example.model.Student;

import java.util.*;

public class StudentRegistration {
    ArrayList<Student> studentList = new ArrayList();
    Scanner scn = new Scanner(System.in);

    public void saveStudent(Student students){
        while(true){
            System.out.print("Enter name: ");
            String studentName = scn.nextLine();

            if(studentName.equals("EXIT")){
                break;
            }

            System.out.print("Enter student ID: ");
            String studentID = scn.nextLine();
            scn.nextLine();

            System.out.print("Enter student program: ");
            String program = scn.nextLine();


            studentList.add(new Student(studentID, studentName, program));
        }
    }

    public void displayAllStudent(){
        for(int i=0;i<studentList.size();i++){
            System.out.println(studentList.get(i));
        }
    }

    public void updateStudent(Student student){
        for (int i=0;i< studentList.size();i++){
            if (studentList.get(i).getStudentID() == (student.getStudentID())){
                System.out.print("Enter Name: ");
                String name = scn.nextLine();

                System.out.print("Enter Program: ");
                String program = scn.nextLine();


                studentList.set(i, new Student(student.getStudentID(), name, program));
                break;
            }
        }
    }

    public void removeStudent(Student student){
        for (int i=0;i< studentList.size();i++) {
            if (studentList.get(i).getStudentID() == (student.getStudentID())) {
                studentList.remove(i);
            }
        }
    }
}
