package com.repository;

import com.domain.Currency;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyRepository {

    private SessionFactory sessionFactory;

    public CurrencyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Currency> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Currency> currencyQuery = session.createQuery("from Currency", Currency.class);
        return currencyQuery.getResultList();
    }

    public Currency create(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.save(currency);
        return currency;
    }

    public Currency get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Currency.class, id);
    }

    public Currency update(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(currency);
        return currency;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Currency currency = get(id);
        if (currency != null) {
            session.delete(currency);
        }
    }
}
