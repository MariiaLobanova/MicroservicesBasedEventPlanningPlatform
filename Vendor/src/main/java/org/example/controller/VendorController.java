package org.example.controller;

import org.example.model.Vendor;
import org.example.playload.CreateVendorRequest;
import org.example.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @GetMapping
    public List<Vendor> getVendors() {

        return vendorService.getVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable("id") Integer id) {

        return vendorService.getVendor(id);
    }

    @PostMapping
    public void registerVendor(@RequestBody CreateVendorRequest createVendorRequest) {
        vendorService.registerVendor(createVendorRequest);
    }


}
