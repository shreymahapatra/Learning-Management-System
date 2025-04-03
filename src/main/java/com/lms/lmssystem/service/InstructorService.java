package com.lms.lmssystem.service;

import com.lms.lmssystem.model.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    Instructor updateInstructor(Long id, Instructor updatedInstructor);
    void deleteInstructor(Long id);
}
