package com.raysi.responseentitypratice.service;

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
        // Save a single watch to the database
        watchRepository.save(watch);
    }

    @Override
    public void saveWatches(List<Watch> watch) {
        // Save a list of watches to the database
        watchRepository.saveAll(watch);
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