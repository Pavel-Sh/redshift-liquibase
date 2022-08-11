package com.example.redshift.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liquibase")
public class MainController {

    @GetMapping
    public ResponseEntity<?> testLiquibase() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
