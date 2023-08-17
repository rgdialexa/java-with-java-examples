package com.dialexa.javawithjava.datapersistence.datapersistencedemo.controller;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.CalculationDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.NumbersDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calculator")
@Slf4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculations")
    public List<CalculationDTO> allCalculations() {
        log.info("Gathering all calculations");
        return calculatorService.getAllCalculations();
    }

    @GetMapping("/calculations/positive")
    public List<CalculationDTO> positiveCalculations() {
        log.info("Gathering all calculations with positive results");
        return calculatorService.getPositiveCalculations();
    }

    @GetMapping("/calculations/negative")
    public List<CalculationDTO> negativeCalculations() {
        log.info("Gathering all calculations with negative results");
        return calculatorService.getNegativeCalculations();
    }

    @GetMapping("/calculations/division")
    public List<CalculationDTO> allDivisionCalculations() {
        log.info("Gathering all calculations using division");
        return calculatorService.getAllDivisionCalculations();
    }

    @GetMapping("/calculations/addition")
    public List<CalculationDTO> allAdditionCalculations() {
        log.info("Gathering all calculations using addition");
        return calculatorService.getAllAdditionCalculations();
    }

    @PostMapping("/divideints")
    public CalculationDTO divideInts(@RequestBody NumbersDTO numbers) {
        log.info(String.format("Received request to divide %s by %s", numbers.getA(), numbers.getB()));
        return calculatorService.divideIntNumbers(numbers);

    }

    @PostMapping("/addints")
    public CalculationDTO addInts(@RequestBody NumbersDTO numbers) {
        log.info(String.format("Received request to add %s to %s", numbers.getA(), numbers.getB()));
        return calculatorService.addIntNumbers(numbers);

    }

    @DeleteMapping("/calculations/delete/{id}")
    public HttpStatus deleteCalculation(@PathVariable("id") String id){
        log.info(String.format("Attempting to delete calculation with id %s", id));
        calculatorService.deleteCalculationById(id);
        return HttpStatus.OK;
    }

}
