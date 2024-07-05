package com.maslanka.out_of_office_solution_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Lists/Projects")
public class ProjectsController {

    @GetMapping()
    public ResponseEntity<?> getProjects(){
        return ResponseEntity.ok("");
    }


}
