package com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.repository;

import com.dialexa.javawithjava.datapersistence.datapersistencedemo.model.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalculationDAO extends JpaRepository<Calculation, UUID> {
}
