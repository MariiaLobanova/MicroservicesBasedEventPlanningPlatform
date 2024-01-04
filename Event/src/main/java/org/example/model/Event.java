package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String event;
    private String description;
    private Date date;
    private Integer clientId;
    private Integer vendorId;

    public Event(String event, String description, Date date, Integer clientId, Integer vendorId ) {
        this.event = event;
        this.description = description;
        this.date = date;
        this.clientId = clientId;
        this.vendorId = vendorId;
    }

}
