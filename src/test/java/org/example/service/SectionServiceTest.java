package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {
    private SectionServiceImpl sectionService;

    @BeforeEach
    void setUp() {
        sectionService = new SectionServiceImpl();
    }

    @Test
    void testAddSectionSuccess() {
        sectionService.addSection(new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0));
        assertEquals(1, sectionService.getAllSections().size());
    }

    @Test
    void testAddSectionDuplicateName() {
        sectionService.addSection(new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0));
        sectionService.addSection(new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0));
        assertEquals(1, sectionService.getAllSections().size());
    }

    @Test
    void testUpdateSection() {
        sectionService.addSection(new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0));
        Section updated = new Section("IT2A", new ArrayList<>(), new ArrayList<>(), 5);

        sectionService.updateSection(updated);

        assertEquals("IT2A", sectionService.getAllSections().get(0).getSectionName());
        assertEquals(5, sectionService.getAllSections().get(0).getCurrentCapacity());
    }

    @Test
    void testAssignStudentToSectionSuccess() {
        Section sec = new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0);
        Student stu = new Student("1001", "John Doe", "IT1A", null, false, new ArrayList<>(), 0);
        sectionService.assignStudentToSection(stu, sec);
        assertEquals(1, sec.getCurrentCapacity());
        assertEquals(sec, stu.getSectionEnrolled());
    }

    @Test
    void testSectionCapacityLimit() {
        Section fullSec = new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 30);
        Student stu = new Student("1001", "Jane Doe", "IT1A", null, false, new ArrayList<>(), 0);
        sectionService.assignStudentToSection(stu, fullSec);
        assertEquals(30, fullSec.getCurrentCapacity());
        assertNull(stu.getSectionEnrolled());
    }

    @Test
    void testDeleteSectionSuccess() {
        sectionService.addSection(new Section("IT1A", new ArrayList<>(), new ArrayList<>(), 0));
        sectionService.deleteSection("IT1A");
        assertEquals(0, sectionService.getAllSections().size());
    }
}
