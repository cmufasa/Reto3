package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.entity.Cabin;
import com.usa.ciclo3.reto3.repository.CabinRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getList() {
        return cabinRepository.findAll();
    }

    public Cabin getById(Long id) {
        return cabinRepository.findById(id).get();
    }

    public Cabin save(Cabin admin) {
        return cabinRepository.save(admin);
    }

    public void delete(Long id) {
        cabinRepository.deleteById(id);
    }

}
