package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.ShowSeat;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{

    @Override
    List<ShowSeat> findAll();

    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    @Override
    Optional<ShowSeat> findById(Long aLong);


    ShowSeat save(ShowSeat showSeat);


}
