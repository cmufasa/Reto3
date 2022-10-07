package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Cabin;
import com.usa.ciclo3.reto3.service.CabinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/Cabin")
public class CabinController {
    
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getCabinList(){
        return cabinService.getList();
    }
    
    @GetMapping("/{id}")
    public Cabin getCabinById(@PathVariable("id") Long id){
        return cabinService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertCabin(@RequestBody Cabin cabin){
       cabinService.save(cabin);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCabin(@PathVariable("id") Long id){
       cabinService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
