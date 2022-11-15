package com.repository;

import com.domain.Employee;
import com.domain.LeaveApplication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class EmployeeRepository {

    private SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<LeaveApplication> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveApplication> leaveQuery = session.createQuery("from LeaveApplication", LeaveApplication.class);
        return leaveQuery.getResultList();
    }

    public boolean create(LeaveApplication LeaveApplication) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(LeaveApplication);
        return true;
    }

    public LeaveApplication get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LeaveApplication.class, id);
    }

    /*public boolean update(Employee employee) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, employee.getFirstname());
        preparedStatement.setString(2, employee.getLastname());
        preparedStatement.setLong(3, employee.getId());
        return preparedStatement.execute();
    }

    public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }

    private List<Employee> mapper(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while(resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong(1));
            employee.setFirstname(resultSet.getString(2));
            employee.setLastname(resultSet.getString(3));
            employees.add(employee);
        }
        return employees;
    }*/
}
