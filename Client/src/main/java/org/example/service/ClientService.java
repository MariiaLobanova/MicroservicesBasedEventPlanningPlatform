package org.example.service;

import org.example.model.Client;
import org.example.playload.CreateClientRequest;
import org.example.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClient(Integer id){
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return client.get();
    }
    public List<Client> getClients(){
        return clientRepository.findAll();
    }


    public void registerClient(CreateClientRequest createClientRequest) {
        Client client = new Client(
                createClientRequest.getName(),
                createClientRequest.getLastname(),
                createClientRequest.getEmail());
        clientRepository.save(client);
    }


}
