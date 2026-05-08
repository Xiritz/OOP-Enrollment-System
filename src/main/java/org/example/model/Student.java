package org.example.model;

public class Student extends Person{
    private String program;
    private Section sectionEnrolled;

    public Student(){

    }

    public Student(String id, String name,String program){
        super(id, name);
        this.program = program;
    }

    public Student(String id, String name,String program, Section section){
        this(id, name, program);
        this.sectionEnrolled = section;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program=program;
    }

    public Section getSectionEnrolled(){
        return sectionEnrolled;
    }

    public void setSectionEnrolled(Section section){
        this.sectionEnrolled = section;
    }


    @Override
    public void mainTask(){
        System.out.println("Studies");
    }





//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentID='" + studentID + '\'' +
//                ", studentName='" + studentName + '\'' +
//                ", program='" + program + '\'' +
//                '}';
//    }


}
