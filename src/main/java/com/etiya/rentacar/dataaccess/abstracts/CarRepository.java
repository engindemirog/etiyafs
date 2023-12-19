package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
