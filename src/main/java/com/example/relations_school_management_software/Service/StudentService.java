package com.example.relations_school_management_software.Service;

import com.example.relations_school_management_software.Api.ApiException;
import com.example.relations_school_management_software.Model.Course;
import com.example.relations_school_management_software.Model.Student;
import com.example.relations_school_management_software.Repository.CourseRepository;
import com.example.relations_school_management_software.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    public void updateStudent(Integer id, Student student) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id ) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("student not found");
        }
        studentRepository.delete(student1);
    }

    public void assignStudentAndCourses(Integer studentId, Integer courseId) {
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(courseId);
        if (student == null) {
            throw new ApiException("Student Id not found");
        }
        if (course == null) {
            throw new ApiException("Course Id not found");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        courseRepository.save(course);
        studentRepository.save(student);
    }

     //Create endpoint that takes student id and major and change the student major(changing the major will drop all the cousres that the student attended to)
    public void changeStudentMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
         if (student == null) {
          throw new ApiException("student not found");
     }
        student.setMajor(major);
        student.getCourses().clear();
        studentRepository.save(student);
    }


}