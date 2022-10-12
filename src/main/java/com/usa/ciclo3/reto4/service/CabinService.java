package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Cabin;
import com.usa.ciclo3.reto4.repository.CabinRepository;
import java.util.List;
import java.util.Optional;
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
    
    public Cabin save(Cabin cabin) {
        return cabinRepository.save(cabin);
    }
    
    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> cabinId = cabinRepository.findById(cabin.getId());
            
            if (!cabinId.isEmpty()) {
                Cabin cabinBd = cabinId.get();
                
                cabinBd.setBrand(cabin.getBrand());
                cabinBd.setRooms(cabin.getRooms());
//                cabinBd.setCategory(cabin.getCategory());
                cabinBd.setName(cabin.getName());
                cabinBd.setDescription(cabin.getDescription());
//                cabinBd.setMessages(cabin.getMessages());                
//                cabinBd.setReservations(cabin.getReservations());
                
                
                return cabinRepository.save(cabinBd);
                
            } else {
                
                return cabin;
            }
        }
        return cabin;
    }
    
    public void delete(Long id) {
        cabinRepository.deleteById(id);
    }
    
}
