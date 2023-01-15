package com.github.SampleRESTApi.services.impl;

import com.github.SampleRESTApi.models.Student;
import com.github.SampleRESTApi.repository.StudentRepository;
import com.github.SampleRESTApi.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServicesImpl implements StudentServices {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id){
        return studentRepository.findById(id);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(String id, Student student){
        Student updatedStudent = studentRepository.findById(id).get();
        if(updatedStudent == null){
            return null;
        }
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setMiddleName(student.getMiddleName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setYearLevel(student.getYearLevel());
        updatedStudent.setSection(student.getSection());
        studentRepository.save(updatedStudent);
        return updatedStudent;
    }

    public Student deleteById(String id){
        Student deleteStudent = studentRepository.findById(id).get();
        if (deleteStudent == null) {
            return null;
        }
        studentRepository.delete(deleteStudent);
        return deleteStudent;
    }

}
