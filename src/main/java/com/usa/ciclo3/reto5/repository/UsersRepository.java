package com.usa.ciclo3.reto5.repository;

import com.usa.ciclo3.reto5.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    
    Users findByUsername(String username);
    
}
