package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "leavetype")
public class LeaveType extends  LeaveApplication {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="Leave_ID")
    private LeaveApplication leaveID;

    @NotNull
    @Column(name = "totalDays")
    private int totalDays;

    @Override
    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    @NotNull
    @Column(name = "category")
    private String category;

    public LeaveApplication getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(LeaveApplication leaveID) {
        this.leaveID = leaveID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}

