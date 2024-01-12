package com.oauth2test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class IncomeController {

  @GetMapping("/income")
  ResponseEntity<String> getIncomes() {
    return ResponseEntity.ok("RETRIEVING ALL INCOMES...");
  }

}
