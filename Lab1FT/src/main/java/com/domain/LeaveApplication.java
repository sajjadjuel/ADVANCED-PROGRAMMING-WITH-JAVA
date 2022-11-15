package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "LeaveApplication")
public class LeaveApplication extends Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveID;

    @NotNull
    @Column(name = "fromDate")
    private LocalDate fromDate;

    public LeaveApplication getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(Long leaveID) {
        this.leaveID = leaveID;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LeaveApplication getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(LeaveApplication employee_ID) {
        Employee_ID = employee_ID;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @ManyToOne
    @JoinColumn(name="Employee_ID")
    private LeaveApplication Employee_ID;

    @NotNull
    @Column(name = "toDate")
    private LocalDate toDate;


    @NotNull
    @Column(name = "date")
    private int totalDays;

    @NotNull
    @Column(name = "reason")
    private String reason;





}

