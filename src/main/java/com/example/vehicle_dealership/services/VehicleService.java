package com.example.vehicle_dealership.services;

import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    //depency inject
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }

    //getAllVehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList;
    }
    //getVehiclesById
    public Optional<Vehicle> getVehicleById(Long id) {
        var vehicle = vehicleRepository.findById(id);
        return vehicle;
    }

    //addVehicle
    public Vehicle create(Vehicle vehicle) {
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        return vehicleRepository.save(vehicle);
    }

    //updateVehicle
    public Vehicle update(Long id, Vehicle vehicle) {
        //search for movie with said ID
        Optional<Vehicle> updateVehicle = vehicleRepository.findById(id);
        if (updateVehicle.isEmpty()) {
            return null;
        }
        //we are now going to update everything to the new values
        Vehicle vehicleToUpdate = updateVehicle.get();
        vehicleToUpdate.setColor(vehicle.getColor());
        vehicleToUpdate.setMake(vehicle.getMake());
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setOdometer(vehicle.getOdometer());
        vehicleToUpdate.setPrice(vehicle.getPrice());
        vehicleToUpdate.setVehicleType(vehicle.getVehicleType());
        vehicleToUpdate.setVin(vehicle.getVin());
        vehicleToUpdate.setYear(vehicle.getYear());
        vehicleRepository.save(vehicleToUpdate);
        return vehicleToUpdate;
    }
    //delete vehicle
    public boolean delete(long id){
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(id);
        if (vehicleToDelete.isEmpty()){
            return false;
        }
        vehicleRepository.delete(vehicleToDelete.get());
        return true;
    }
    public List<Vehicle> getVehiclesByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        if (minPrice != null && maxPrice != null) {
            return vehicleRepository.findByPriceBetween(minPrice, maxPrice);
        }
        return vehicleRepository.findAll();
    }

}