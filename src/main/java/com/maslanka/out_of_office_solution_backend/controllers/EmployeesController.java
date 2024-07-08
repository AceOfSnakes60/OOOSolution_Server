package com.maslanka.out_of_office_solution_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lists/employees")
public class EmployeesController {

    @GetMapping()
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok().body("");
    }

    @PostMapping()
    public ResponseEntity<?> addEmployee() {
        return ResponseEntity.ok().body("");
    }

    @PatchMapping()
    public ResponseEntity<?> updateEmployee(){
        return ResponseEntity.ok().body("");
    }


    //Get - filter

    //Search by name

    //Add

    //Update

    //Deactivate

    //Assign to project

}
