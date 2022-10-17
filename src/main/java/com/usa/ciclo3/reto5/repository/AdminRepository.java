package com.usa.ciclo3.reto5.repository;

import com.usa.ciclo3.reto5.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
