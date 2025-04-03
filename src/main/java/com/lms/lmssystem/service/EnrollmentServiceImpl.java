package com.lms.lmssystem.service;

import com.lms.lmssystem.dto.StudentProgressReport;
import com.lms.lmssystem.model.Enrollment;
import com.lms.lmssystem.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentServiceImpl.class);

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment enrollStudent(Enrollment enrollment) {
        Enrollment saved = enrollmentRepository.save(enrollment);
        logger.info("Student enrolled: Student ID {}, Course ID {}", saved.getStudent().getId(), saved.getCourse().getId());
        return saved;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        logger.info("Fetching all enrollments...");
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        logger.info("Fetching enrollments for student ID: {}", studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        logger.info("Fetching enrollments for course ID: {}", courseId);
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteEnrollment(Long id) {
        logger.info("Deleting enrollment with ID: {}", id);
        enrollmentRepository.deleteById(id);
    }

    @Override
    public List<StudentProgressReport> getStudentProgressReport() {
        return enrollmentRepository.getStudentProgressReport();
    }

}
