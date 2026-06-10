package com.example.lms.model;

import jakarta.persistence.*; //JPA import

@Entity                     //Created to work with Hibernate
@Table(name = "student")


public class Student {

    @Id            // created primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;    //changed for int to integer
    private String name;
    private String course;

    public Student() {
    }

    public Student(Integer id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}