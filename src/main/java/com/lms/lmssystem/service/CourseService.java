package com.lms.lmssystem.service;

import com.lms.lmssystem.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course updatedCourse);

}
