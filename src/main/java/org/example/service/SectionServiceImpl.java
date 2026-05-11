package org.example.service;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements SectionService{
    private List<Section> sections = new ArrayList<>();

    @Override
    public void addSection(Section section) {
        boolean exists = false;
        for (Section s : sections) {
            if (s.getSectionName().equals(section.getSectionName())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Section name already exists!");
        } else {
            sections.add(section);
        }
    }

    @Override
    public List<Section> getAllSections() {
        return sections;
    }

    @Override
    public void deleteSection(String sectionName) {
        boolean removed = false;
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equals(sectionName)) {
                sections.remove(i);
                System.out.println("Section removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Section not found.");
        }
    }

    @Override
    public void updateSection(Section section) {
        boolean found = false;
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equals(section.getSectionName())) {
                sections.set(i, section);
                System.out.println("Section record updated in system.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Section not found.");
        }
    }

    @Override
    public void assignStudentToSection(Student student, Section section) {
        if (section.getCurrentCapacity() >= 30){
            System.out.println("Section is full! Cannot enroll " + student.getName());
            return;
        }
if (section.equals(student.getSectionEnrolled())){
    System.out.println("Student is already enrolled in this section!");
    return;
}

for (Course course : section.getCourses()) {
    if (course.getPrerequisite() != null) {
                boolean canEnroll = false;
                for (Course passedCourse : student.getPassedCourses()) {
                    if (passedCourse.getCourseID().equals(course.getPrerequisite().getCourseID())) {
                        canEnroll = true;
                        break;
                    }
                }
                if (!canEnroll) {
                    System.out.println(course.getPrerequisite().getCourseName() + " for course: " + course.getCourseName());
                    return;
                }
            }
        }

        student.setSectionEnrolled(section);
        int totalUnits = 0;
        for (Course course : section.getCourses()) {
            totalUnits += course.getUnits();
        }
        student.setUnitsEnrolled(student.getUnitsEnrolled() + totalUnits);
        section.setCurrentCapacity(section.getCurrentCapacity() + 1);
        section.getEnrolledStudents().add(student);
        System.out.println("Student " + student.getName() + " enrolled in " + section.getSectionName() + ". Total units added: " + totalUnits);
    }

    @Override
    public void assignCourseToSection(Course course, Section section) {
        section.addCourse(course);
    }
}
