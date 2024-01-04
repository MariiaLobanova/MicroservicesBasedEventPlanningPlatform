package org.example.controller;

import org.example.model.Event;
import org.example.playload.CreateEventRequest;
import org.example.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {

        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getVendor(@PathVariable("id") Integer id) {

        return eventService.getEvent(id);
    }

    @PostMapping
    public void registerVendor(@RequestBody CreateEventRequest createEventRequest) {
        eventService.registerEvent(createEventRequest);
    }


}
