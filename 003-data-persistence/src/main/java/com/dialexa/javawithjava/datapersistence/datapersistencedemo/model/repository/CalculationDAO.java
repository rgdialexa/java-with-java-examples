package com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.repository;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CalculationDAO extends JpaRepository<Calculation, UUID> {
    public List<Calculation> findByResultGreaterThanEqual(int comparisonNumber);
    public List<Calculation> findByResultLessThan(int comparisonNumber);

    @Query(
            value = "SELECT * FROM calculations where operation = '/'",
            nativeQuery = true
    )
    public List<Calculation> findAllDivisionCalculations();

    @Query(
            value = "SELECT * FROM calculations where operation = '+'",
            nativeQuery = true
    )
    public List<Calculation> findAllAdditionCalculations();
}
