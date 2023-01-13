package com.github.SampleRESTApi.repository;

import com.github.SampleRESTApi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
