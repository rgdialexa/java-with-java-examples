package com.dialexa.javawithjava.datapersistence.datapersistencedemo.controller;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.CalculationResponseDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.NumbersDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calculator")
@Slf4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping()
    public List<CalculationResponseDTO> calculator() {
        log.info("Gathering all calculations");
        return calculatorService.getAllCalculations();
    }

    @PostMapping("/divideints")
    public CalculationResponseDTO divideInt(@RequestBody NumbersDTO numbers) {
        log.info(String.format("Received request to divide %s by %s", numbers.getA(), numbers.getB()));
        try {
            return calculatorService.divideIntNumbers(numbers);
        } catch (Exception ex) {
           log.error(String.format("An error occurred: %s", ex));
           throw ex;
        }
    }

}
