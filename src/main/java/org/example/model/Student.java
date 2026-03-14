package org.example.model;

public class Student extends Person{
    private String program;

    public Student(){

    }
    public Student(int id, String name,String program){
        super(id, name);
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program=program;
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
