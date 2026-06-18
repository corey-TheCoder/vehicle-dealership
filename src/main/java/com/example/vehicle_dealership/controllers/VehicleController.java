package com.example.vehicle_dealership.controllers;


import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    //I.J
    private VehicleService vehicleService;
    //optional annotation
    @Autowired
    public VehicleController(VehicleService vehicleService){this.vehicleService=vehicleService;}
    //get vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(
        @RequestParam(required = false) BigDecimal minPrice,
        @RequestParam(required = false) BigDecimal maxPrice){
            List<Vehicle> vehicles = vehicleService.getVehiclesByPrice(minPrice, maxPrice);
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody @Valid Vehicle vehicle){
        Vehicle newVehicle = vehicleService.create(vehicle);
        return  new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Vehicle> updateVehicle(@RequestBody @Valid Vehicle vehicle, @PathVariable Long id) {
        Vehicle updateVehicle = this.vehicleService.update(id, vehicle);
        if (updateVehicle == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(updateVehicle, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle (@PathVariable Long id){
        boolean deleted = this.vehicleService.delete(id);
        if (!deleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
