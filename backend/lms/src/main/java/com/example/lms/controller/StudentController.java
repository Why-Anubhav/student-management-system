package com.example.lms.controller; // create package for global access

import com.example.lms.model.Student;  // import according to model.name package
import org.springframework.web.bind.annotation.*;

@RestController               //allows use of rest APIs 
@RequestMapping("/student")  // maps request 
@CrossOrigin(origins ="http://localhost:5173") // connect with frontend
public class StudentController {

@GetMapping
    public Student getStudent() {

        return new Student(
                1,
                "Tushar",
                "MCA"
        );
    }
}