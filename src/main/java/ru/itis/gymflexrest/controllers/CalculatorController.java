package ru.itis.gymflexrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.gymflexrest.dto.CalculatorDto;
import ru.itis.gymflexrest.services.CalculatorService;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<Long> calculate(@RequestBody CalculatorDto calculatorDto) {
        long result = calculatorService.calculate(calculatorDto);
        return ResponseEntity.ok(result);
    }
}
