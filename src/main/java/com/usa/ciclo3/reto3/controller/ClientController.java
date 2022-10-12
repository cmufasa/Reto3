package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Client;
import com.usa.ciclo3.reto3.service.ClientService;
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
@RequestMapping(value = "api/Client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public List<Client> getClientList(){
        return clientService.getList();
    }
    
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertClient(@RequestBody Client client){
       clientService.save(client);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
       clientService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
