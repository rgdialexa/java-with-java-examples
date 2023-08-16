package com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class CalculationDTO {
    private UUID id;
    private int firstNumber;
    private int secondNumber;
    private String operation;
    private int result;
    private String notes;
}
