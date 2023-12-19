package com.etiya.rentacar.business.rules.cars;

import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    CarRepository carRepository;

    public void EachBrandCanContainMaxTenCars(int brandId){
        int carCountInGivenBrand = carRepository.countByBrandId(brandId);

        if(carCountInGivenBrand>=5)
        {
            throw new RuntimeException("Each brand can contain max 10 cars");
        }
    }
}
