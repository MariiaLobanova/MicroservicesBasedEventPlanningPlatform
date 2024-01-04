package org.example.repository;

import org.example.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository <Vendor, Integer> {
}
