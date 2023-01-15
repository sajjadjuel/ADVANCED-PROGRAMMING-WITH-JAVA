package com.service;

import com.domain.Course;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CourseService {

    public Course insert(Course course);

    public Course get(Long id);

    public List<Course> getAll();

    public Course getByUserName(String username);

    public Course update(Course course);

    public void delete(Long id);
}
