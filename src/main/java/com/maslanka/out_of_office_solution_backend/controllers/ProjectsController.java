package com.maslanka.out_of_office_solution_backend.controllers;

import com.maslanka.out_of_office_solution_backend.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Lists/Projects")
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping()
    public ResponseEntity<?> getProjects(
            @RequestParam Map<String, String> allParams){
        projectRepository.getProjects();
        return ResponseEntity.ok("");
    }

    //Sort/filter/search
    //get details
    //Add/update/deactivate

    @PostMapping()
    public ResponseEntity<?> addProject(){

        return ResponseEntity.ok("");
    }

    @PatchMapping()
    public ResponseEntity<?> updateProject(){

        return ResponseEntity.ok("");
    }
}
