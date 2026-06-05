package com.example.lms.controller; // create package for global access

import com.example.lms.model.Student;  // import according to model.name package
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController               //allows use of rest APIs 
@RequestMapping("/student")  // maps request 
@CrossOrigin(origins ="http://localhost:5173") // connect with frontend
public class StudentController {

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
}