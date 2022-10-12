package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Message;
import com.usa.ciclo3.reto4.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
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

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageId = messageRepository.findById(message.getIdMessage());

            if (!messageId.isEmpty()) {
                Message messageBd = messageId.get();

                messageBd.setMessageText(message.getMessageText());
                messageBd.setCabin(message.getCabin());
                messageBd.setClient(message.getClient());

                return messageRepository.save(messageBd);

            } else {

                return message;
            }
        }
        return message;
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

}
