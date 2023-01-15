package com.repository;

/*import com.domain.LeaveApplication;*/
import com.domain.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseImplRepository implements CourseRepository {

    private SessionFactory sessionFactory;

    public CourseImplRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Course> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Course> courseQuery = session.createQuery("from Course", Course.class);
        return courseQuery.getResultList();
    }

    public Course getByUserName(String course_name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Course> courseListQuery = session.createQuery("from Course t where t.course_name='"+course_name+"'");
        return courseListQuery.getSingleResult();
    }

    public Course create(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
        return course;
    }

    public Course get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    public Course update(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(course);
        return course;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = get(id);
        if (course != null) {
            session.delete(course);
        }
    }
}
