package com.example.lms.service;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.exception.StudentNotFoundException;  //exception
import com.example.lms.model.Student;
import com.example.lms.repository.studentRepository;

@Service 
public class StudentService {

    private final JdbcTemplate jdbcTemplate;

    public String getStudentInfo(){
        return "Student Service is working!";
    }
    
    public String getStudentCount(){         //created to replace from controller 
        String sql = "SELECT COUNT(*) FROM student";
        return jdbcTemplate.queryForObject(sql,Integer.class).toString();
    }
    
        @Autowired
        private studentRepository repository;

	    public StudentService(studentRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
            this.jdbcTemplate = jdbcTemplate;
    }

        public List<Student> getAllStudents() {
        return repository.findAll();

    }

    public Student saveStudent( Student student) {
    return repository.save(student);
    }

    public Student getStudentById(Integer id) {   //Error Handling
    return repository
            .findById(id)
            .orElseThrow(
                    () -> new StudentNotFoundException("Student Not Found" + id));
    }

    public Student addStudent(StudentRequestDTO dto) {
    Student student = new Student();
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());
    return repository.save(student);
    }


    public Student updateStudent(Integer id, StudentRequestDTO dto) {
    Student student = repository
	                    .findById(id)
	                    .orElseThrow( () -> new StudentNotFoundException(
                                            "Student Not Found with id: " + id));

    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
    }

    public String deleteStudent(Integer id) {
    repository.deleteById(id);
    return "Student Deleted with id: " + id;
    }



}
