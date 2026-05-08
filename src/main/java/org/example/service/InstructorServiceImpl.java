package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements InstructorService{
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(String id, String name, List<Course> courses) {
        instructorList.add(new Instructor(id, name, courses, new ArrayList<>()));
    }

    @Override
    public void assignInstructorToCourse(Instructor instructor, Course course) {
        course.setInstructor(instructor);
        if (!instructor.getCourses().contains(course)) {
            instructor.getCourses().add(course);
        }
    }

    @Override
    public void getInstructorDetails(Instructor instructor) {
        System.out.println("Instructor ID: " + instructor.getId());
        System.out.println("Instructor Name: " + instructor.getName());
        instructor.mainTask();
    }

}
