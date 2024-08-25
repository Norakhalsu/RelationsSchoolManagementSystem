package com.example.relations_school_management_software.Repository;

import com.example.relations_school_management_software.Model.Course;
import com.example.relations_school_management_software.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);

  // List<Student> findStudentByCourseId(Integer id);
    //@Query("select t from")

}
