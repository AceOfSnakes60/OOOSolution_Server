package com.maslanka.out_of_office_solution_backend.Output;

import com.maslanka.out_of_office_solution_backend.Models.Employee;
import com.maslanka.out_of_office_solution_backend.Models.LeaveRequest;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;

public class ApprovalRequestResponse {
    private int id;
    private Employee approver;
    private LeaveRequest leaveRequest;
    private ApprovalStatusEnum approvalStatus;
    private String comment;
}
