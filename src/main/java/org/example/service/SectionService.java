package org.example.service;

import org.example.model.*;

public interface SectionService {
    void addSection(String name, Course course);
    void deleteSection(int sectionIndex);
    void assignStudentToSection(Student student, Section section);
    void assignCourseToSection(Course course, Section section);
    void getSectionDetails();

}

