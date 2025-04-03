package com.lms.lmssystem.service;

import com.lms.lmssystem.exception.ResourceNotFoundException;
import com.lms.lmssystem.model.Instructor;
import com.lms.lmssystem.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private static final Logger logger = LoggerFactory.getLogger(InstructorServiceImpl.class);

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor createInstructor(Instructor instructor) {
        Instructor saved = instructorRepository.save(instructor);
        logger.info("Instructor created: {}", saved.getName());
        return saved;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        logger.info("Fetching all instructors...");
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        logger.info("Fetching instructor with ID: {}", id);
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with ID: " + id));
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        logger.info("Updating instructor with ID: {}", id);
        Instructor existing = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));

        existing.setName(updatedInstructor.getName());
        existing.setEmail(updatedInstructor.getEmail());

        Instructor saved = instructorRepository.save(existing);
        logger.info("Instructor updated: {}", saved.getName());
        return saved;
    }

    @Override
    public void deleteInstructor(Long id) {
        logger.info("Deleting instructor with ID: {}", id);
        instructorRepository.deleteById(id);
    }
}
