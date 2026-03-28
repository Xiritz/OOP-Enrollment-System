package org.example.service;
import org.example.model.*;

import java.util.*;

public class StudentRegistrationImpl implements StudentRegistration {
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
            int studentID = scn.nextInt();
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
            if (studentList.get(i).getId() == (student.getId())){
                System.out.print("Enter Name: ");
                String name = scn.nextLine();

                System.out.print("Enter Program: ");
                String program = scn.nextLine();


                studentList.set(i, new Student(student.getId(), name, program));
                break;
            }
        }
    }

    public void removeStudent(Student student){
        for (int i=0;i< studentList.size();i++) {
            if (studentList.get(i).getId() == (student.getId())) {
                studentList.remove(i);
            }
        }
    }
}
