package com.lms.lmssystem.service;

import com.lms.lmssystem.model.Course;
import com.lms.lmssystem.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCourses() {
        Course c1 = new Course(1L, "Java", "Learn Java", null, null);
        Course c2 = new Course(2L, "Python", "Learn Python", null, null);

        when(courseRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Course> courses = courseService.getAllCourses();

        assertEquals(2, courses.size());
        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void testGetCourseById_Found() {
        Course course = new Course(1L, "Spring Boot", "Learn Spring Boot", null, null);
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course result = courseService.getCourseById(1L);
        assertNotNull(result);
        assertEquals("Spring Boot", result.getTitle());
    }

    @Test
    void testCreateCourse() {
        Course course = new Course(null, "New Course", "Course Description", null, null);
        Course savedCourse = new Course(1L, "New Course", "Course Description", null, null);

        when(courseRepository.save(course)).thenReturn(savedCourse);

        Course result = courseService.createCourse(course);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testDeleteCourse() {
        doNothing().when(courseRepository).deleteById(1L);
        courseService.deleteCourse(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }
}
