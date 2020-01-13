package com.pluralsight.demo.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

    Optional<TicketType> findByCode(String code);
}
