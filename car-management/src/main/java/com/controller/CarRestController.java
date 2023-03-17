package com.controller;

import com.model.Car;
import com.model.CarType;
import com.model.DeparturePoint;
import com.model.Destination;
import com.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CarRestController {
    @Autowired
    private ICarService carService;

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getCar() {
        List<Car> carList = carService.findAll();
        if (carList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/carType")
    public ResponseEntity<List<CarType>> getCarType() {
        List<CarType> carTypeList = carService.findAllCarType();
        if (carTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carTypeList, HttpStatus.OK);
    }

    @GetMapping("/destination")
    public ResponseEntity<List<Destination>> getDestination() {
        List<Destination> destinationList = carService.findAllDestination();
        if (destinationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationList, HttpStatus.OK);
    }

    @GetMapping("/departurePoint")
    public ResponseEntity<List<DeparturePoint>> getDeparturePoint() {
        List<DeparturePoint> destinationList = carService.findAllDeparturePoint();
        if (destinationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationList, HttpStatus.OK);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Car> getCategory(@PathVariable Long id) {
        Optional<Car> categoryOptional = carService.findById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/car/create")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car car1 = carService.create(car);
        if (car1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car1, HttpStatus.OK);
    }

    @PutMapping("/car/edit/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Optional<Car> carOptional = carService.findById(id);
        return carOptional.map(car1 -> {
            car.setId(car1.getId());
            return new ResponseEntity<>(carService.update(car), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(car, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        Optional<Car> carOptional = carService.findById(id);
        return carOptional.map(car -> {
            carService.delete(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
