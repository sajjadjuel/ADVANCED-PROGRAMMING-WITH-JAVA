package com.repository;

import com.domain.Tax;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxRepository {

    private SessionFactory sessionFactory;

    public TaxRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Tax> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Tax> taxQuery = session.createQuery("from Tax", Tax.class);
        return taxQuery.getResultList();
    }

    public Tax create(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tax);
        return tax;
    }

    public Tax get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tax.class, id);
    }

    public Tax update(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tax);
        return tax;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Tax tax = get(id);
        if (tax != null) {
            session.delete(tax);
        }
    }
   /* public Tax getByUserId(Long user_id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Tax> taxQuery = session.createQuery("from Tax where user_id = :user_id", Tax.class);
        taxQuery.setParameter("user_id", user_id);
        return taxQuery.getSingleResult();
    }*/

    public List<Tax> getByUserId( Long user_id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Tax> taxListQuery = session.createQuery("from Tax t where t.user_id='"+user_id+"'");
        return taxListQuery.getResultList();

    }
}
