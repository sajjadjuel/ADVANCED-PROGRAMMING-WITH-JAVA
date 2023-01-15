package com.service;

import com.domain.Course;
/*import com.repository.TaxUserImplRepository;*/
import com.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseImplService implements CourseService {

    private CourseRepository courseRepository;

    public CourseImplService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course insert(Course course) {
        return courseRepository.create(course);
    }

    @Transactional(readOnly = true)
    public Course get(Long id) {
        return courseRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Course getByUserName(String username) {
        return courseRepository.getByUserName(username);
    }

    @Transactional
    public Course update(Course taxUser) {
        return courseRepository.update(taxUser);
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.delete(id);
    }
}
