package com.repository;

import com.domain.Course;

import java.util.List;

public interface CourseRepository {

    public List<Course> getAll();
    public Course getByUserName(String course_name);

    public Course create(Course course);

    public Course get(Long id);

    public Course update(Course c);

    public void delete(Long id);
}
