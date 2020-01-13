package com.pluralsight.demo.database;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricingCategoryRepository extends JpaRepository<PricingCategory, String> {

    Optional<PricingCategory> findByCode(String code);

    @Query("from PricingCategory pc where pc.startDate <= :date and pc.endDate > :date")
    Optional<PricingCategory> findByDate(@Param("date") LocalDate date);
}
