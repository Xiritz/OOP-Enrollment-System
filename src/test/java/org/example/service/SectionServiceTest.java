package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {
    private SectionServiceImpl sectionService;

    @BeforeEach
    void setUp() {
        sectionService = new SectionServiceImpl();
    }

    @Test
    void testAddSectionSuccess() {
        sectionService.addSection(new Section("BSCS-1A", 0));
        assertEquals(1, sectionService.getAllSections().size());
    }

    @Test
    void testAddSectionDuplicateName() {
        sectionService.addSection(new Section("BSCS-1A", 0));
        sectionService.addSection(new Section("BSCS-1A", 0));
        assertEquals(1, sectionService.getAllSections().size());
    }

    @Test
    void testUpdateSectionInteractive() {
        sectionService.addSection(new Section("OldName", 0));
        Section s = sectionService.getAllSections().get(0);

        String input = "NewName\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        sectionService.updateSection(s);

        assertEquals("NewName", sectionService.getAllSections().get(0).getSectionName());
        System.setIn(System.in);
    }

    @Test
    void testAssignStudentToSectionSuccess() {
        Section sec = new Section("BSCS-1A", 0);
        Student stu = new Student("1001", "John", "BSCS");
        sectionService.assignStudentToSection(stu, sec);
        assertEquals(1, sec.getCurrentCapacity());
        assertEquals(sec, stu.getSectionEnrolled());
    }

    @Test
    void testSectionCapacityLimit() {
        Section fullSec = new Section("FULL", 30);
        Student stu = new Student("1001", "John", "BSCS");
        sectionService.assignStudentToSection(stu, fullSec);
        assertEquals(30, fullSec.getCurrentCapacity());
        assertNull(stu.getSectionEnrolled());
    }

    @Test
    void testDeleteSectionSuccess() {
        sectionService.addSection(new Section("BSCS-1A", 0));
        sectionService.deleteSection("BSCS-1A");
        assertEquals(0, sectionService.getAllSections().size());
    }
}
