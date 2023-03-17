package com.repository;

import com.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ICarRepository extends JpaRepository<Car, Long> {
}
