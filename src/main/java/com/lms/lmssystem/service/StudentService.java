package com.lms.lmssystem.service;

import com.lms.lmssystem.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Long id, Student updatedStudent);
}
