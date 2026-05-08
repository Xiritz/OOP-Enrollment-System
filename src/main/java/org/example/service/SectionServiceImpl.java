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
    public void assignStudentToSection(Student student, Section section) {
        if (section.getCurrentCapacity() >= 30){
            System.out.println("Section is full! Cannot enroll " + student.getName());
            return;
        }

        if (section.equals(student.getSectionEnrolled())){
            System.out.println("Student is already enrolled in this section!");
            return;
        }

        student.setSectionEnrolled(section);
        section.setCurrentCapacity(section.getCurrentCapacity() + 1);
        System.out.println("Student " + student.getName() + " enrolled in " + section.getSectionName());
    }

    @Override
    public void assignCourseToSection(Course course, Section section) {
        section.addCourse(course);
    }
}
