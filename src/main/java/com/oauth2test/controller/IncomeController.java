package com.oauth2test.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/v1")
public class IncomeController {

  @GetMapping("/income")
  @ResponseBody
  Object getIncomes() {
    Map<String, Object> object = new HashMap<>();
    object.put("key1", "value1");
    object.put("key2", "value2");
    return object;
  }

}
