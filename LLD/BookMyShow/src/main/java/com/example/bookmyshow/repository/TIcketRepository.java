package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TIcketRepository extends JpaRepository<Ticket, Long> {

    @Override
    Ticket save(Ticket entity);
}
