package com.example.vehicle_dealership.repositories;

import com.example.vehicle_dealership.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,
        Long> {
    //no code
    //something I didn't understand at first but
    //the JPA already has CRDU functions built in.
    //we are inheriting that here I'm assuming
    List<Vehicle> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
