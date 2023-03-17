package com.repository;

import com.model.DeparturePoint;
import com.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDestinationRepository extends JpaRepository<Destination, Long> {
    @Query(value = "")
    List<Destination> findAllDestination();
}
