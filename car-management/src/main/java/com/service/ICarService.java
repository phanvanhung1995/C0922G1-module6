package com.service;

import com.model.Car;
import com.model.CarType;
import com.model.DeparturePoint;
import com.model.Destination;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICarService {
    List<Car> findAll();

    List<CarType> findAllCarType();

    List<DeparturePoint> findAllDeparturePoint();

    List<Destination> findAllDestination();

    Optional<Car> findById(Long id);

    Car create(Car car);

    Car update(Car car);

    void delete(Long id);
}
