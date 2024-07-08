package com.maslanka.out_of_office_solution_backend.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lists/LeaveRequests")
public class LeaveRequestsController {

    //Available to all
    @GetMapping
    public ResponseEntity<?> getRequests(){
        // Sort/Filter Requests

        return ResponseEntity.ok().body("");
    }

    // Only Employees:
    @PostMapping
    public ResponseEntity<?> postRequest(){
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
