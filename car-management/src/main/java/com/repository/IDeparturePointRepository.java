package com.repository;

import com.model.CarType;
import com.model.DeparturePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDeparturePointRepository extends JpaRepository<DeparturePoint, Long> {

    List<DeparturePoint> findAllDeparturePoint();
}
