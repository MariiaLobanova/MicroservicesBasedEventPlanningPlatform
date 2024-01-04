package org.example.service;

import org.apache.coyote.Response;
import org.example.model.Event;
import org.example.playload.CreateEventRequest;
import org.example.repository.EventRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private EventRepository eventRepository;
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
        String clientsUrl = "http://localhost:8085/api/clients/" + createEventRequest.getClientId();
        String vendorsUrl = "http://localhost:8095/api/vendors/" + createEventRequest.getVendorId();
        try {
            restTemplate.exchange(clientsUrl, HttpMethod.GET, null, String.class);
            restTemplate.exchange(vendorsUrl, HttpMethod.GET, null, String.class);

            Event event = new Event(
                    createEventRequest.getEvent(),
                    createEventRequest.getDescription(),
                    createEventRequest.getDate(),
                    createEventRequest.getClientId(),
                    createEventRequest.getVendorId());
            eventRepository.save(event);
        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
