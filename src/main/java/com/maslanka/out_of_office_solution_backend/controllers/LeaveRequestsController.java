package com.maslanka.out_of_office_solution_backend.controllers;


import com.maslanka.out_of_office_solution_backend.Models.LeaveRequest;
import com.maslanka.out_of_office_solution_backend.Repositories.LeaveRequestRepository;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lists/LeaveRequests")
public class LeaveRequestsController {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    //Available to all
    @GetMapping
    public ResponseEntity<?> getRequests(){
        // Sort/Filter Requests
        List<LeaveRequest> leaveRequestList = leaveRequestRepository.getLeaveRequests();
        return ResponseEntity.ok().body(leaveRequestList);
    }

    // Only Employees:
    @PostMapping
    public ResponseEntity<?> postRequest(@RequestBody LeaveRequest leaveRequest){
        leaveRequest.setApprovalStatus(ApprovalStatusEnum.NEW.ordinal());
        leaveRequestRepository.addLeaveRequest(leaveRequest);
        return ResponseEntity.ok().body("");
    }

    @PatchMapping
    public ResponseEntity<?> updateRequest(){

        return ResponseEntity.ok().body("");
    }

    //Get: Sort-Filter
    // Search by name
    // Approve/Reject
    // Create Request
    // Update Request


}
