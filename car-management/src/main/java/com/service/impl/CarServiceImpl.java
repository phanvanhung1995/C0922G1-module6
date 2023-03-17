package com.service.impl;

import com.model.Car;
import com.model.CarType;
import com.model.DeparturePoint;
import com.model.Destination;
import com.repository.ICarRepository;
import com.repository.ICarTypeRepository;
import com.repository.IDeparturePointRepository;
import com.repository.IDestinationRepository;
import com.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ICarTypeRepository carTypeRepository;
    @Autowired
    private IDestinationRepository destinationRepository;
    @Autowired
    private IDeparturePointRepository departurePointRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<CarType> findAllCarType() {
        return carTypeRepository.findAll();
    }

    @Override
    public List<DeparturePoint> findAllDeparturePoint() {
        return departurePointRepository.findAll();
    }

    @Override
    public List<Destination> findAllDestination() {
        return destinationRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
