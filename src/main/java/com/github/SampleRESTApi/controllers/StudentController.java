package com.github.SampleRESTApi.controllers;

import com.github.SampleRESTApi.models.Student;
import com.github.SampleRESTApi.services.impl.StudentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentServicesImpl studentServices;

    @CrossOrigin
    @GetMapping
    public List<Student> getStudents(){
        System.out.println("Get Students API called");
        return studentServices.getStudents();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Student> getStudents(@PathVariable String id){
        System.out.println("Get Student API called");
        return studentServices.getStudentById(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        System.out.println("Save Student API called");
        return studentServices.save(student);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        System.out.println("Update Student API called");
        return studentServices.update(id, student);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable String id){
        System.out.println("Delete Student API called");
        return studentServices.deleteById(id);
    }
}
