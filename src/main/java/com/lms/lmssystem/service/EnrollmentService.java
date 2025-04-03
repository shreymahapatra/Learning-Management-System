package com.lms.lmssystem.service;

import com.lms.lmssystem.dto.StudentProgressReport;
import com.lms.lmssystem.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(Enrollment enrollment);
    List<Enrollment> getAllEnrollments();
    List<Enrollment> getEnrollmentsByStudentId(Long studentId);
    List<Enrollment> getEnrollmentsByCourseId(Long courseId);
    void deleteEnrollment(Long id);
    List<StudentProgressReport> getStudentProgressReport();

}
