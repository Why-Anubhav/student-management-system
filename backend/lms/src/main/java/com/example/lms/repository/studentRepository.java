package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lms.model.Student;

public interface studentRepository  extends JpaRepository <Student, Integer>{
    
}
