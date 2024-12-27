package com.raysi.responseentitypratice.controller;

import com.raysi.responseentitypratice.entity.Watch;
import com.raysi.responseentitypratice.service.WatchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class WatchController {

    private final WatchService watchService;

    // Constructor-based dependency injection for better testability and immutability
    public WatchController(WatchService watchService){
        this.watchService = watchService;
    }

    // Fetch all watches
    @GetMapping("/api/watch")
    public ResponseEntity<List<Watch>> fetchWatches(){
        List<Watch> watch = watchService.getWatches();
        // Returns 200 OK with the list of watches
        return new ResponseEntity<>(watch, HttpStatus.OK);
    }

    // Fetch a watch by its ID
    @GetMapping("api/watch/{id}")
    public ResponseEntity<?> fetchWatchById(@PathVariable Long id){
        Optional<Watch> watch = Optional.ofNullable(watchService.getWatchById(id));
        // Handle case where watch is not found
        if(!watch.isPresent()){
            HashMap<String, String> status = new HashMap<>();
            status.put("message", "Watch with id : " + id + " not Found");
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        }
        // Returns 200 OK with the watch data
        return new ResponseEntity<>(watch, HttpStatus.OK);
    }

    // Save a list of watches
    @PostMapping("/api/watches")
    public ResponseEntity<?> saveWatches(@Valid @RequestBody List<Watch> watches){
        // Validate input and save all watches
        watchService.saveWatches(watches);
        // Returns 201 Created with the saved data
        return new ResponseEntity<>(watches.toString(), HttpStatus.CREATED);
    }

    // Save a single watch
    @PostMapping("/api/watch")
    public ResponseEntity<?> saveWatches(@Valid @RequestBody Watch watch){
        // Validate input and save the watch
        watchService.saveWatch(watch);
        // Returns 201 Created with the saved watch data
        return new ResponseEntity<>(watch.toString(), HttpStatus.CREATED);
    }

    // Delete a watch by its ID
    @DeleteMapping("/api/watch/{id}")
    public ResponseEntity<?> deleteWatch(@PathVariable Long id){
        // Service call to delete the watch
        watchService.deleteWatch(id);
        // Returns 200 OK with a success message
        return new ResponseEntity<>("Watch deleted successfully", HttpStatus.OK);
    }
}