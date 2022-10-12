package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Client;
import com.usa.ciclo3.reto4.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getList() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).get();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientId = clientRepository.findById(client.getIdClient());

            if (!clientId.isEmpty()) {
                Client clientBd = clientId.get();

                clientBd.setName(client.getName());
                clientBd.setEmail(client.getEmail());
                clientBd.setPassword(client.getPassword());
                clientBd.setAge(client.getAge());
                clientBd.setMessages(client.getMessages());
                clientBd.setReservations(client.getReservations());

                return clientRepository.save(clientBd);

            } else {

                return client;
            }
        }
        return client;
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
