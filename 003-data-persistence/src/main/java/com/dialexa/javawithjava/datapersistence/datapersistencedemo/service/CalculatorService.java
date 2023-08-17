package com.dialexa.javawithjava.datapersistence.datapersistencedemo.service;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.CalculationDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.NumbersDTO;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.entity.Calculation;
import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.repository.CalculationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class CalculatorService {

    public static final String DIVISION_OPERATION_SYMBOL = "/";
    public static final String ADDITION_OPERATION_SYMBOL = "+";
    public static final String DIVISION_OPERATION_NOTES = "secondNumber is divisor";
    public static final String ADDITION_OPERATION_NOTES = "N/A";

    @Autowired
    private CalculationDAO calculationDAO;

    public CalculationDTO addIntNumbers(NumbersDTO numbers) {
        log.info(String.format("Attempting to add %s to %s", numbers.getA(), numbers.getB()));
        try {
            int result = numbers.getA() + numbers.getB();
            Calculation calculation = Calculation.builder()
                    .firstNumber(numbers.getA())
                    .secondNumber(numbers.getB())
                    .operation(ADDITION_OPERATION_SYMBOL)
                    .result(result)
                    .notes(ADDITION_OPERATION_NOTES)
                    .build();
            calculationDAO.save(calculation);
            return calculation.toDTO();
        } catch (Exception ex) {
            log.error(String.format("An error occurred: %s", ex));
            throw ex;
        }
    }

    public CalculationDTO divideIntNumbers(NumbersDTO numbers) {
        log.info(String.format("Attempting to divide %s by %s", numbers.getA(), numbers.getB()));
        try {
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
        } catch (Exception ex) {
            log.error(String.format("An error occurred: %s", ex));
            throw ex;
        }
    }

    public List<CalculationDTO> getAllCalculations() {
        return mapCalculationListToDTOList(calculationDAO.findAll());
    }

    public List<CalculationDTO> getPositiveCalculations() {
        return mapCalculationListToDTOList(calculationDAO.findByResultGreaterThanEqual(0));
    }

    public List<CalculationDTO> getNegativeCalculations() {
        return mapCalculationListToDTOList(calculationDAO.findByResultLessThan(0));
    }

    public List<CalculationDTO> getAllAdditionCalculations() {
        return mapCalculationListToDTOList(calculationDAO.findAllAdditionCalculations());
    }

    public List<CalculationDTO> getAllDivisionCalculations() {
        return mapCalculationListToDTOList(calculationDAO.findAllDivisionCalculations());
    }

    private List<CalculationDTO> mapCalculationListToDTOList(List<Calculation> calculations) {
        List<CalculationDTO> calculationDTOS = new ArrayList<CalculationDTO>();
        calculations.forEach((calculation) -> {
            calculationDTOS.add(calculation.toDTO());
        });
        return calculationDTOS;
    }

    public void deleteCalculationById(String id) {
        try {
            log.info(String.format("Attempting to delete calculation with ID %s", id));
            calculationDAO.deleteById(UUID.fromString(id));
        } catch (Exception ex) {
            log.error(String.format("An error occurred: %s", ex));
            throw ex;
        }
    }

}
