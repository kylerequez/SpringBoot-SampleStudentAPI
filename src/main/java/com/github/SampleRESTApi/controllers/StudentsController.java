package com.github.SampleRESTApi.controllers;

import com.github.SampleRESTApi.models.Student;
import com.github.SampleRESTApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(value = "/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public Student updateUser(@PathVariable String id, @RequestBody Student student){
        Student updatedStudent = studentRepository.findById(id).get();
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setMiddleName(student.getMiddleName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setYearLevel(student.getYearLevel());
        updatedStudent.setSection(student.getSection());

        return studentRepository.save(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public String updateUser(@PathVariable String id){
        Student deleteStudent = studentRepository.findById(id).get();
        studentRepository.delete(deleteStudent);
        return "Deleted " + id + "...";
    }
}
