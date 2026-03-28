package org.example.service;
import org.example.model.Course;

import java.util.*;

public class CourseRegistrationImpl implements CourseRegistration {
    ArrayList<Course> courses = new ArrayList();
    Scanner scn = new Scanner(System.in);
    public void save(){
        while(true){
            System.out.print("Enter course name: ");
            String courseName = scn.nextLine();

            if(courseName.equals("EXIT")){
                break;
            }

            System.out.print("Enter course ID: ");
            String courseID = scn.nextLine();
            scn.nextLine();

            System.out.print("Enter program: ");
            String program = scn.nextLine();


            courses.add(new Course(courseID, courseName, program));
        }
    }

    public void display(){
            for(int i=0;i<courses.size();i++){
            System.out.println(courses.get(i));
        }
    }

    public void updateCourse(Course course){
        for (int i=0;i< courses.size();i++){
            if (courses.get(i).getCourseID() == (course.getCourseID())){
                System.out.print("Enter Name: ");
                String name = scn.nextLine();

                System.out.print("Enter Program: ");
                String program = scn.nextLine();


                courses.set(i, new Course(course.getCourseID(), name, program));
                break;
            }
        }
    }

    public void removeCourse(){

    }
}
