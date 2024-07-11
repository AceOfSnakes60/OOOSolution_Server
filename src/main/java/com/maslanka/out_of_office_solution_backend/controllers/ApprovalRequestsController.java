package com.maslanka.out_of_office_solution_backend.controllers;


import com.maslanka.out_of_office_solution_backend.Models.ApprovalRequest;
import com.maslanka.out_of_office_solution_backend.Repositories.ApprovalRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lists/ApprovalRequests")
public class ApprovalRequestsController {

    private ApprovalRequestRepository approvalRequestRepository;
    @GetMapping()
    public ResponseEntity<?> getApprovalRequests(){

        return ResponseEntity.ok().body(approvalRequestRepository.getAllARequests());
    }

    @PostMapping
    public ResponseEntity<?> addApprovalRequest(@RequestBody ApprovalRequest approvalRequest){
        int approvalRequestId = approvalRequestRepository.addApprovalRequest(approvalRequest);

        return ResponseEntity.ok(approvalRequestId);
    }

    //Sort/filter/search
    //open with details
    //Approve or reject Request
    //Create approval

}
