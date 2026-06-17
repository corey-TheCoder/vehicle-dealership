package com.example.vehicle_dealership.services;

import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    //depency inject
    @Autowired
    private VehicleRepository vehicleRepository;

    //getAllVehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList;
    }

    //search movies
    public List<Vehicle> searchVehicles(String vin) {
        return vehicleRepository.findByTitleContainingIgnoreCase(vin);
    }

    //getVehiclesById
    public Optional<Vehicle> getVehicleById(Long id) {
        var vehicle = vehicleRepository.findById(id);
        return vehicle;
    }

    //addVehicle
    public Vehicle create(Vehicle vehicle) {
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        return newVehicle;
    }

    //updateVehicle
    public Vehicle update(Long id, Vehicle vehicle) {
        //search for movie with said ID
        Optional<Vehicle> updateVehicle = vehicleRepository.findById(id);
        if (!updateVehicle.isEmpty()) {
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
        return vehicleToUpdate;f
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
}