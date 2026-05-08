package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(String id, String name, List<Course> courses) {
        boolean exists = false;
        for (Instructor i : instructorList) {
            if (i.getId().equals(id)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Instructor ID already exists!");
        } else {
            instructorList.add(new Instructor(id, name, courses, new ArrayList<>()));
            System.out.println("Instructor added successfully.");
        }
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorList;
    }

    @Override
    public void removeInstructor(String id) {
        boolean removed = false;
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(id)) {
                instructorList.remove(i);
                System.out.println("Instructor removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Instructor not found.");
        }
    }

    @Override
    public void assignInstructorToCourse(Instructor instructor, Course course) {
        course.setInstructor(instructor);
        if (!instructor.getCourses().contains(course)) {
            instructor.getCourses().add(course);
            System.out.println("Course " + course.getCourseName() + " assigned to Instructor " + instructor.getName());
        } else {
            System.out.println("Instructor already assigned to this course.");
        }
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        java.util.Scanner scn = new java.util.Scanner(System.in);
        boolean found = false;
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(instructor.getId())) {
                System.out.print("Enter Instructor Name: ");
                String name = scn.nextLine();
                
                instructorList.set(i, new Instructor(instructor.getId(), name, instructor.getCourses(), instructor.getSections()));
                System.out.println("Instructor updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Instructor not found.");
        }
    }

    @Override
    public void getInstructorDetails(Instructor instructor) {
        System.out.println("Instructor ID: " + instructor.getId());
        System.out.println("Instructor Name: " + instructor.getName());
        instructor.mainTask();
    }
}
