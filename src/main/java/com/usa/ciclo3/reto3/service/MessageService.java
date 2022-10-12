package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.entity.Message;
import com.usa.ciclo3.reto3.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getList() {
        return messageRepository.findAll();
    }

    public Message getById(Long id) {
        return messageRepository.findById(id).get();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

}
