package com.example.vehicle_dealership.repositories;

import com.example.vehicle_dealership.entities.Dealership;
import com.example.vehicle_dealership.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership,
        Long> {
    List<Dealership> findByNameContainingIgnoreCase(String name);
}
