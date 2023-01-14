package com.github.SampleRESTApi.controllers;

import com.github.SampleRESTApi.models.Student;
import com.github.SampleRESTApi.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentServices.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudents(@PathVariable String id){
        return studentServices.getStudentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentServices.save(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        return studentServices.update(id, student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable String id){
        return studentServices.deleteById(id);
    }
}
