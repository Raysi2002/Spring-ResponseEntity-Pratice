package com.raysi.responseentitypratice.repository;

import com.raysi.responseentitypratice.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {
}
