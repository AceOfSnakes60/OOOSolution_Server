package com.maslanka.out_of_office_solution_backend.Models;

import com.maslanka.out_of_office_solution_backend.SelectionLists.AbsenceReasonEnum;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;

import java.util.Date;

public class LeaveRequest {
    private long id;
    private long employee;
    private AbsenceReasonEnum absenceReason;
    private Date startDate;
    private Date endDate;
    private String comment;
    private ApprovalStatusEnum approvalStatus;

    public void setId(long id) { this.id = id;}
    public void setEmployee(long employee) {this.employee = employee;}
    public void setAbsenceReason(int absenceReason) {this.absenceReason = AbsenceReasonEnum.values()[absenceReason];}
    public void setStartDate(Date startDate) {this.startDate = startDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}
    public void setComment(String comment) {this.comment = comment;}
    public void setApprovalStatus(int approvalStatus){this.approvalStatus = ApprovalStatusEnum.values()[approvalStatus];}

    public long getId() {
        return id;
    }

    public long getEmployee() {
        return employee;
    }

    public AbsenceReasonEnum getAbsenceReason() {
        return absenceReason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getComment() {
        return comment;
    }

    public ApprovalStatusEnum getApprovalStatus() {
        return approvalStatus;
    }
}
