package org.example.service;

import org.example.model.Vendor;
import org.example.playload.CreateVendorRequest;
import org.example.repository.VendorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    public Vendor getVendor(Integer id){
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return vendor.get();
    }
    public List<Vendor> getVendors(){
        return vendorRepository.findAll();
    }


    public void registerVendor(CreateVendorRequest createVendorRequest) {
        Vendor vendor = new Vendor(createVendorRequest.getName(),
                createVendorRequest.getService());
        vendorRepository.save(vendor);
    }


}
