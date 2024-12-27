package com.raysi.responseentitypratice.service;

import com.raysi.responseentitypratice.entity.Watch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatchService {
    List<Watch> getWatches();
    Watch getWatchById(Long id);
    void saveWatch(Watch watch);
    void saveWatches(List<Watch> watch);
    void deleteWatch(Long id);
    void updateWatch(Long id, Watch watch);
}
