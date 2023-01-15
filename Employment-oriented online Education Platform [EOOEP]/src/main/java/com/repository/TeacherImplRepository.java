package com.repository;
import com.domain.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherImplRepository implements TeacherRepository {

    private SessionFactory sessionFactory;

    public TeacherImplRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Teacher> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> teacherQuery = session.createQuery("from Teacher", Teacher.class);
        return teacherQuery.getResultList();
    }

    public Teacher getByUserName(String user_name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Teacher> teacherQuery = session.createQuery("from Teacher t where t.user_name='"+user_name+"'");
        return teacherQuery.getSingleResult();
    }

    public Teacher create(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
        return teacher;
    }

    public Teacher get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    public Teacher update(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(teacher);
        return teacher;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = get(id);
        if (teacher != null) {
            session.delete(teacher);
        }
    }
}
