package com.dialexa.lombokloggingdebugging.lombokloggingdebugging.controllers;

import com.dialexa.lombokloggingdebugging.lombokloggingdebugging.models.Numbers;
import com.dialexa.lombokloggingdebugging.lombokloggingdebugging.models.NumbersLombok;
import com.dialexa.lombokloggingdebugging.lombokloggingdebugging.services.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
@Slf4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping()
    public String calculatorWelcome() {
        return "Welcome to the calculator controller";
    }

    @PostMapping("/divideints")
    public int divideInt(@RequestBody Numbers numbers) {
        log.info(String.format("Received request to divide %s by %s without using lombok.", numbers.getA(), numbers.getB()));
        int result = 0;
        try {
            result = calculatorService.divideIntNumbers(numbers);
        } catch (Exception ex) {
           log.error(String.format("An error occurred: %s", ex));
           throw ex;
        }

        return result;
    }

    @PostMapping("/divideintslombok")
    public int divideIntLombok(@RequestBody NumbersLombok numbersLombok) {
        log.info(String.format("Received request to divide %s by %s using lombok. %s", numbersLombok.getA(), numbersLombok.getB()));
        int result = 0;
        try {
            result = calculatorService.divideIntNumbersLombok(numbersLombok);
        } catch (Exception ex) {
            log.error(String.format("An error occurred: %s", ex));
            throw ex;
        }

        return result;
    }

}
