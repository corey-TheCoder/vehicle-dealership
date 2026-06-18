package com.example.vehicle_dealership.services;

import com.example.vehicle_dealership.entities.Dealership;
import com.example.vehicle_dealership.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DealershipService {
    @Autowired
    private DealershipRepository dealershipRepository;

    //get dealership
    public List<Dealership> getAllDealerships(){
        List<Dealership> dealershipList = dealershipRepository.findAll();
        return dealershipList;
    }
    //search dealership
    public List<Dealership> searchDealerships(String name){
        return dealershipRepository.findByNameContainingIgnoreCase(name);
    }
    //add dealership
    public Dealership create(Dealership dealership){
        Dealership newDealership = dealershipRepository.save(dealership);
        return newDealership;
    }
    //update
    public Dealership update(Long id, Dealership dealership) {
        Optional<Dealership> updateDealership = dealershipRepository.findById(id);
        if (updateDealership.isEmpty()) {
            return null;
        }
        Dealership dealershipToUpdate = updateDealership.get();
        dealershipToUpdate.setName(dealership.getName());
        dealershipToUpdate.setAddress(dealership.getAddress());
        dealershipToUpdate.setPhoneNum(dealership.getPhoneNum());
        dealershipRepository.save(dealershipToUpdate);
        return dealershipToUpdate;
    }

        //delete
        public boolean delete(long id) {
            Optional<Dealership> dealershipToDelete = dealershipRepository.findById(id);
            if (dealershipToDelete.isEmpty()) {
                return false;
            }
            dealershipRepository.delete(dealershipToDelete.get());
            return true;
        }
    }

