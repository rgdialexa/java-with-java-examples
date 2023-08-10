package com.dialexa.lombokloggingdebugging.lombokloggingdebugging.services;

import com.dialexa.lombokloggingdebugging.lombokloggingdebugging.models.Numbers;
import com.dialexa.lombokloggingdebugging.lombokloggingdebugging.models.NumbersLombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public int divideIntNumbers(Numbers numbers) {
        log.info(String.format("Attempting to divide %s by %s without lombok", numbers.getA(), numbers.getB()));
        return numbers.getA() / numbers.getB();
    }

    public int divideIntNumbersLombok(NumbersLombok numbersLombok) {
        log.info(String.format("Attempting to divide %s by %s with lombok", numbersLombok.getA(), numbersLombok.getB()));
        return numbersLombok.getA() / numbersLombok.getB();
    }

}
