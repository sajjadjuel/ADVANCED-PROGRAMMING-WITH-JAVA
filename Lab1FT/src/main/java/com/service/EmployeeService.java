package com.service;

import com.domain.*;
import com.domain.LeaveApplication;
import com.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) throws SQLException {
        leaveApplication.setFromDate(leaveApplication.getFromDate());
        leaveApplication.setToDate(leaveApplication.getToDate());
        leaveApplication.setReason(leaveApplication.getReason());
        return employeeRepository.create(leaveApplication);
    }
}
