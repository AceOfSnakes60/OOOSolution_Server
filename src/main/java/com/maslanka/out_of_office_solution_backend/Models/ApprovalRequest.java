package com.maslanka.out_of_office_solution_backend.Models;

import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;

public class ApprovalRequest {
    private int id;
    private int approver;
    private int leaveRequest;
    private ApprovalStatusEnum approvalStatus;
    private String comment;


    public void setID(int id){
        this.id = id;
    }

    public void setApprover(int approver){
        this.approver = approver;
    }

    public void setLeaveRequest(int leaveRequest){
        this.leaveRequest = leaveRequest;
    }

    public void setApprovalStatus(int approvalStatus){
        this.approvalStatus = ApprovalStatusEnum.values()[approvalStatus];
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int getApprover() {
        return approver;
    }

    public int getLeaveRequest() {
        return leaveRequest;
    }

    public ApprovalStatusEnum getApprovalStatus() {
        return approvalStatus;
    }

    public String getComment() {
        return comment;
    }
}
