package com.example.relations_school_management_software.Service;

import com.example.relations_school_management_software.Api.ApiException;
import com.example.relations_school_management_software.Model.Teacher;
import com.example.relations_school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
       return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }


    public void updateTeacher(Integer id,Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id) {
        Teacher t=teacherRepository.findTeacherById(id);
        if(t==null) {
            throw new ApiException("Teacher Not Found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null) {
            throw new ApiException("Teacher Not Found");
        }
        return teacher;
    }

}
