package com.example.midexam;

public class StudentModel {
    private Integer id;
    private String studentId;
    private String name;
    private int age;

    public StudentModel(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public StudentModel(Integer id, String studentId, String name, int age) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}