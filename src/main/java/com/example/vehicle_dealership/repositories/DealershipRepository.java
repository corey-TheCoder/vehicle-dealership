package com.example.vehicle_dealership.repositories;

import com.example.vehicle_dealership.entities.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipRepository extends JpaRepository<Dealership,
        Long> {
}
