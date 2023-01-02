package com.repository;

import com.domain.StudentEooep;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentEooepRepository {

    private SessionFactory sessionFactory;

    public StudentEooepRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<StudentEooep> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<StudentEooep> studentEooepQuery = session.createQuery("from StudentEooep", StudentEooep.class);
        return studentEooepQuery.getResultList();
    }

    public StudentEooep create(StudentEooep studentEooep) {
        Session session = sessionFactory.getCurrentSession();
        session.save(studentEooep);
        return studentEooep;
    }

    public StudentEooep get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StudentEooep.class, id);
    }

    public StudentEooep update(StudentEooep studentEooep) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(studentEooep);
        return studentEooep;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        StudentEooep studentEooep = get(id);
        if (studentEooep != null) {
            session.delete(studentEooep);
        }
    }
    public StudentEooep getByStudentEooepname(String studentEooep_name) {
        Session session = sessionFactory.getCurrentSession();
        Query<StudentEooep> studentEooepQuery = session.createQuery("from StudentEooep where studentEooep_name = :studentEooep_name", StudentEooep.class);
        studentEooepQuery.setParameter("studentEooep_name", studentEooep_name);
        return studentEooepQuery.getSingleResult();
    }
}
