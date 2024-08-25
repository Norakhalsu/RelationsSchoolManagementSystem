package com.example.relations_school_management_software.Repository;

import com.example.relations_school_management_software.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);

   // List<Student> findStudentsByCourseId(Integer courseId);

}
