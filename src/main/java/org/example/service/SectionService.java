package org.example.service;

import org.example.model.*;

import java.util.List;

public interface SectionService {
    void addSection(Section section);
    List<Section> getAllSections();
    void deleteSection(String sectionName);
    void updateSection(Section section);
    void assignStudentToSection(Student student, Section section);
    void assignCourseToSection(Course course, Section section);
}

