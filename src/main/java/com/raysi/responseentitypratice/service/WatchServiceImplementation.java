package com.raysi.responseentitypratice.service;

import com.raysi.responseentitypratice.customexception.BussinessException;
import com.raysi.responseentitypratice.entity.Watch;
import com.raysi.responseentitypratice.repository.WatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service // Marks this class as a Spring service component
public class WatchServiceImplementation implements WatchService {

    private final WatchRepository watchRepository;

    // Constructor-based dependency injection for the repository
    public WatchServiceImplementation(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public List<Watch> getWatches() {
        // Fetch all watches from the database
        return watchRepository.findAll();
    }

    @Override
    public Watch getWatchById(Long id) {
        // Fetch a single watch by ID, or throw an exception if not found
        return watchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with id " + id + " not found"));
    }

    @Override
    public void saveWatch(Watch watch) {
       try{
           if(watch.getName().isEmpty() || watch.getName().isBlank()){
               throw new BussinessException("701", "Name can't be empty");
           }
           watchRepository.save(watch);
       }catch (IllegalArgumentException e){
           throw new BussinessException("702", "Invalid input from user" + e.getMessage());
       }
    }

    @Override
    public void saveWatches(List<Watch> watches) {
        // Save a list of watches to the database
        boolean flag = false;
        for(Watch watch : watches){
            if(watch.getName().isBlank() || watch.getName().isEmpty()){
                flag = true;
            }
        }
        try{
            if(flag){
                throw new BussinessException("701", "Name can't be empty");
            }
            watchRepository.saveAll(watches);
        }catch (IllegalArgumentException e){
            throw new BussinessException("702", "Invalid input from user" + e.getMessage());
        }catch (Exception e){
            throw new BussinessException("703", "Something went wrong in service layer" + e.getMessage());
        }
    }

    @Override
    public void deleteWatch(Long id) {
        // Delete a watch by its ID
        watchRepository.deleteById(id);
    }

    @Override
    public void updateWatch(Long id, Watch watch) {
        // Placeholder for the update method, implementation to be added later
    }
}