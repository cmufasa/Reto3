package com.usa.ciclo3.reto4.repository;

import com.usa.ciclo3.reto4.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
