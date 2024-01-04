package org.example.playload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateClientRequest {
    private String name;
    private String lastname;
    private String email;


}
