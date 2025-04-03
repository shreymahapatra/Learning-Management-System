package com.lms.lmssystem.repository;

import com.lms.lmssystem.dto.StudentProgressReport;
import com.lms.lmssystem.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);

    @Query("SELECT new com.lms.lmssystem.dto.StudentProgressReport(" +
            "s.id, s.name, COUNT(e), AVG(e.grade), MAX(e.grade), MIN(e.grade)) " +
            "FROM Enrollment e JOIN e.student s GROUP BY s.id, s.name")
    List<StudentProgressReport> getStudentProgressReport();
}
