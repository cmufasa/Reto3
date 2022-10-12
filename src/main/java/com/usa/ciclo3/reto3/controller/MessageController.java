package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Message;
import com.usa.ciclo3.reto3.service.MessageService;
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
@RequestMapping(value = "api/Message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessageList(){
        return messageService.getList();
    }
    
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable("id") Long id){
        return messageService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertMessage(@RequestBody Message message){
       messageService.save(message);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMessage(@PathVariable("id") Long id){
       messageService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
