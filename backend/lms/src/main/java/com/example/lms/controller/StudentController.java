package com.example.lms.controller; // create package for global access

import com.example.lms.model.Student;  // import according to model.name package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import com.example.lms.service.StudentService;



@RestController               //allows use of rest APIs 
@RequestMapping("/student")  // maps request 
@CrossOrigin(origins ="http://localhost:5173") // connect with frontend
public class StudentController {
        @Autowired
        private StudentService service;

    @GetMapping
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(
                new Student(1, "Tushar", "MCA")
        );
        students.add(
                new Student(2, "Rahul", "MCA")
        );
        students.add(
                new Student(3, "Aman", "BTech")
        );
        return students;
        
    }
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/count")
    public String countStudents() {
        return service.getStudentCount();
    }

    @GetMapping("/message")
    public String GetstudentInfo() {
        return service.getStudentInfo();
    }

    // @GetMapping
    // public List<Student> getStudentsInfo() {
    //     return service.getAllStudents();
    // }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
    return service.saveStudent(student);
}
    
}