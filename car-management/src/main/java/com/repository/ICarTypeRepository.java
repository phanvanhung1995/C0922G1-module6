package com.repository;

import com.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarTypeRepository extends JpaRepository<CarType, Long> {
    List<CarType> findAllCar();
}
