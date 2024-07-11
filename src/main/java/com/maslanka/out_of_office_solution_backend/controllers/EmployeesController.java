package com.maslanka.out_of_office_solution_backend.controllers;

import com.maslanka.out_of_office_solution_backend.Models.Employee;
import com.maslanka.out_of_office_solution_backend.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Lists/employees")
public class EmployeesController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public ResponseEntity<?> getEmployees(
            @RequestParam Map<String, String> allParams
    ){
        List<Employee> employeeList = employeeRepository.getEmployees(allParams);

        return ResponseEntity.ok().body(employeeList);
    }

    @PostMapping()
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        int employeeId = employeeRepository.addEmployee(employee);

        return ResponseEntity.ok().body(employeeId);
    }

    @PatchMapping()
    public ResponseEntity<?> updateEmployee(){

        return ResponseEntity.ok().body("");
    }



}
