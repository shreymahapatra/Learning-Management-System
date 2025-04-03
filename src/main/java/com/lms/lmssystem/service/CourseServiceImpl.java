package com.lms.lmssystem.service;

import com.lms.lmssystem.exception.ResourceNotFoundException;
import com.lms.lmssystem.model.Course;
import com.lms.lmssystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        Course saved = courseRepository.save(course);
        logger.info("Course created: {}", saved.getTitle());
        return saved;
    }

    @Override
    public List<Course> getAllCourses() {
        logger.info("Fetching all courses...");
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        logger.info("Fetching course with ID: {}", id);
        return courseRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Course not found with ID: {}", id);
                    return new ResourceNotFoundException("Course not found with ID: " + id);
                });
    }

    @Override
    public void deleteCourse(Long id) {
        logger.info("Deleting course with ID: {}", id);
        courseRepository.deleteById(id);
    }

    // ✅ NEW METHOD: Update Course
    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
        logger.info("Updating course with ID: {}", id);

        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Course not found for update with ID: {}", id);
                    return new ResourceNotFoundException("Course not found with ID: " + id);
                });

        existing.setTitle(updatedCourse.getTitle());
        existing.setDescription(updatedCourse.getDescription());
        existing.setInstructor(updatedCourse.getInstructor());

        Course saved = courseRepository.save(existing);
        logger.info("Course updated: {}", saved.getTitle());
        return saved;
    }
}
