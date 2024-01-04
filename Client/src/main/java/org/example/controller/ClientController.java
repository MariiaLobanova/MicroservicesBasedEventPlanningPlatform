package org.example.controller;

import org.example.model.Client;
import org.example.playload.CreateClientRequest;
import org.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") Integer id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public void registerClient(@RequestBody CreateClientRequest createClientRequest) {
        clientService.registerClient(createClientRequest);
    }


}
