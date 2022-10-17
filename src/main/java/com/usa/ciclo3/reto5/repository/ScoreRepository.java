package com.usa.ciclo3.reto5.repository;

import com.usa.ciclo3.reto5.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{
    
}
