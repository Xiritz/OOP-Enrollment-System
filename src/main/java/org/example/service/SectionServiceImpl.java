package org.example.service;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements SectionService{
    private List<Section> sections = new ArrayList();

    @Override
    public void addSection(String name, Course course) {
        Section newSection = new Section(name, 0);
        newSection.addCourse(course);
        sections.add(newSection);
    }

    @Override
    public void deleteSection(int sectionIndex) {
        sections.remove(sectionIndex);
    }

    @Override
    public void assignStudentToSection(Student student, Section section) {
        if (section.getCurrentCapacity() == 30){
            System.out.println("Section is full! Cannot enroll " + student.getName());
        }

        if (section.equals(student.getSectionEnrolled())){
            System.out.println("Student is already enrolled in this section!");
        }

        student.setSectionEnrolled(section);
        section.setCurrentCapacity(section.getCurrentCapacity() + 1);
    }

    @Override
    public void assignCourseToSection(Course course, Section section) {
        section.addCourse(course);
    }

    @Override
    public void getSectionDetails() {
        for (Section section : sections) {
            System.out.println("Section: " + section.getSectionName());
            System.out.println("Current Capacity: " + section.getCurrentCapacity() + "/30");
            System.out.println("Courses:");
            for (Course course : section.getCourses()) {
                String instructorName = (course.getInstructor() != null) ? course.getInstructor().getName() : "No instructor assigned";
                System.out.println("  - " + course.getCourseName() + " (ID: " + course.getCourseID() + ") | Instructor: " + instructorName);
            }
            System.out.println("---------------------------");
        }
    }
}
