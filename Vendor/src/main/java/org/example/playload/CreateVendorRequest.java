package org.example.playload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateVendorRequest {
    private String name;
    private String service;


}
