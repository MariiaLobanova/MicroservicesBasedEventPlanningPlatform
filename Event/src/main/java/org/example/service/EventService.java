package org.example.service;

import org.example.model.Client;
import org.example.model.Event;
import org.example.playload.CreateClientRequest;
import org.example.playload.CreateEventRequest;
import org.example.repository.ClientRepository;
import org.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EventService{

    private final EventRepository eventRepository;
    private final RestTemplate restTemplate;


    public EventService(EventRepository eventRepository) {

        this.eventRepository = eventRepository;
        restTemplate = new RestTemplate();
    }

    public Event getEvent(Integer id){
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return event.get();
    }
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }


    public void registerEvent(CreateEventRequest createEventRequest) {
        String clientUrl = "http://localhost:8085/api/clients/"+ createEventRequest.getClientId();
        String vendorUrl = "http://localhost:8095/api/vendors/"+ createEventRequest.getVendorId();

        try {
            restTemplate.exchange(clientUrl, HttpMethod.GET, null, String.class);
            restTemplate.exchange(vendorUrl, HttpMethod.GET, null, String.class);
            eventRepository.save(new Event(createEventRequest.getEvent(),
                    createEventRequest.getDescription(),
                    createEventRequest.getDate(),
                    createEventRequest.getClientId(),
                    createEventRequest.getVendorId()));

        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

