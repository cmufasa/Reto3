package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
