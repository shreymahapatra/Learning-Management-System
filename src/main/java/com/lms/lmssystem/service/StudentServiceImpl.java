package com.lms.lmssystem.service;

import com.lms.lmssystem.exception.ResourceNotFoundException;
import com.lms.lmssystem.model.Student;
import com.lms.lmssystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        Student saved = studentRepository.save(student);
        logger.info("Student created: {}", saved.getName());
        return saved;
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Fetching all students...");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        logger.info("Fetching student with ID: {}", id);
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with ID: " + id);
                });
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Deleting student with ID: {}", id);
        studentRepository.deleteById(id);
    }

    // ✅ NEW: Update Student
    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        logger.info("Updating student with ID: {}", id);

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found for update with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with ID: " + id);
                });

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());

        Student saved = studentRepository.save(existing);
        logger.info("Student updated: {}", saved.getName());
        return saved;
    }
}
