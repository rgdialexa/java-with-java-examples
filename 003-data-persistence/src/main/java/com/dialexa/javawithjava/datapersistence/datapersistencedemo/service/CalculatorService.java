package com.dialexa.javawithjava.datapersistence.datapersistencedemo.service;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.CalculationResponseDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.NumbersDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.entity.Calculation;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.repository.CalculationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CalculatorService {

    public static final String DIVISION_OPERATION_SYMBOL = "/";
    public static final String DIVISION_OPERATION_NOTES = "secondNumber is divisor";

    @Autowired
    private CalculationDAO calculationDAO;

    public CalculationResponseDTO divideIntNumbers(NumbersDTO numbers) {
        log.info(String.format("Attempting to divide %s by %s", numbers.getA(), numbers.getB()));
        int result = numbers.getA() / numbers.getB();
        Calculation calculation = Calculation.builder()
                .firstNumber(numbers.getA())
                .secondNumber(numbers.getB())
                .operation(DIVISION_OPERATION_SYMBOL)
                .result(result)
                .notes(DIVISION_OPERATION_NOTES)
                .build();
        calculationDAO.save(calculation);
        return calculation.toDTO();
    }

    public List<CalculationResponseDTO> getAllCalculations() {
        List<CalculationResponseDTO> calculationResponseDTOs = new ArrayList<CalculationResponseDTO>();
        List<Calculation> calculations = calculationDAO.findAll();
        calculations.forEach((calculation) -> {
            calculationResponseDTOs.add(calculation.toDTO());
        });
        return calculationResponseDTOs;
    }

}
