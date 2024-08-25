package com.example.relations_school_management_software.Service;

import com.example.relations_school_management_software.Api.ApiException;
import com.example.relations_school_management_software.Model.Course;
import com.example.relations_school_management_software.Model.Student;
import com.example.relations_school_management_software.Model.Teacher;
import com.example.relations_school_management_software.Repository.CourseRepository;
import com.example.relations_school_management_software.Repository.StudentRepository;
import com.example.relations_school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    public final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer courseId, Course course) {
        Course course1 = courseRepository.findCourseById(courseId);

        if (course1 == null) {
            throw new ApiException("Course not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course);
    }


    public void deleteCourse(Integer id) {
        Course course1 = courseRepository.findCourseById(id);
        if (course1 == null) {
            throw new ApiException("Course Not Found");
        }
        courseRepository.delete(course1);
    }



        public void assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Course course1 = courseRepository.findCourseById(courseId);
        Teacher teacher1 = teacherRepository.findTeacherById(teacherId);
        if (course1 == null) {
            throw new ApiException("Course Not Found");
        }
        if (teacher1 == null) {
            throw new ApiException("Teacher Not Found");
        }
         course1.setTeacher(teacher1);
        courseRepository.save(course1);
    }


     public Course getCourseById(Integer id) {
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("Course Id not found");
        }
        return course;
    }


    //Create endpoint that takes class id and return the student list
    public Set<Student> getStudentListByCourse(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course Id not found");
        }

        return  course.getStudents();
    }







}

