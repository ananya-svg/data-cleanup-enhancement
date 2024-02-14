package com.project.datacleanupenhancement.controller;

import com.project.datacleanupenhancement.service.MyRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class MyRestController {

    @Autowired
    private MyRestService dataService;

    @PostMapping("/clean")
    public ResponseEntity<Object> cleanData(@RequestBody List<Map<String, Object>> inputData) {
        List<Map<String, Object>> cleanedData = dataService.cleanData(inputData);
        return ResponseEntity.ok(cleanedData);
    }

    @PostMapping("/enhance")
    public ResponseEntity<Object> enhanceData(@RequestBody List<Map<String, Object>> inputData) {
        List<Map<String, Object>> enhancedData = dataService.enhanceData(inputData);
        return ResponseEntity.ok(enhancedData);
    }
}
