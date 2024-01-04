package org.example.playload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CreateEventRequest {
    private String event;
    private String description;
    private Date date;
    private Integer clientId;
    private Integer vendorId;


}
