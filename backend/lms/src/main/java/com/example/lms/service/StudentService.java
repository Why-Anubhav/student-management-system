package com.example.lms.service;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.lms.model.Student;
import com.example.lms.repository.studentRepository;

@Service 
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getStudentInfo(){
        return "Student Service is working!";
    }
    
    public String getStudentCount(){         //created to replace from controller 

        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql,Integer.class).toString();
    }
        @Autowired
        private studentRepository repository;

	    public StudentService(studentRepository repository) {
        this.repository = repository;
    }

        public List<Student> getAllStudents() {
        return repository.findAll();

    }

    public Student saveStudent( Student student) {
    return repository.save(student);
}


}
