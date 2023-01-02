package com.service;

import com.domain.LeaveApplication;

import java.util.List;

public interface LeaveApplicationService {

    public LeaveApplication insert(LeaveApplication leaveApplication);

    public LeaveApplication get(Long id);

    public List<LeaveApplication> getAll();

    public LeaveApplication update(LeaveApplication leaveApplication);

    public void delete(Long id);
}
