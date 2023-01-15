package com.github.SampleRESTApi.services;

import com.github.SampleRESTApi.models.Student;
import com.github.SampleRESTApi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentServices {

    public List<Student> getStudents();
    public Optional<Student> getStudentById(String id);
    public Student save(Student student);
    public Student update(String id, Student student);

    public Student deleteById(String id) ;
}
