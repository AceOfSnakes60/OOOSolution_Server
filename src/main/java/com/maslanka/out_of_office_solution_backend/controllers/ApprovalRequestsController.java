package com.maslanka.out_of_office_solution_backend.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Lists/ApprovalRequests")
public class ApprovalRequestsController {
    @GetMapping()
    public ResponseEntity<?> getApprovalRequests(){
        return ResponseEntity.ok().body("");
    }

    //Sort/filter/search
    //open with details
    //Approve or reject Request
    //Create approval

}
