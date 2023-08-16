package com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.entity;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.dto.CalculationResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name="calculations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {
    @Id
    @GeneratedValue
    private UUID id;
    private int firstNumber;
    private int secondNumber;
    private int result;
    private String operation;
    private String notes;

    public CalculationResponseDTO toDTO()
    {
        return CalculationResponseDTO.builder()
                .id(this.id)
                .firstNumber(this.firstNumber)
                .secondNumber(this.secondNumber)
                .result(this.result)
                .operation(this.operation)
                .notes(this.notes)
                .build();
    }
}
