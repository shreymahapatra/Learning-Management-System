package com.lms.lmssystem.repository;

import com.lms.lmssystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
