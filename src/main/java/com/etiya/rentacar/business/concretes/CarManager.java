package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.BrandRepository;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import com.etiya.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    CarRepository carRepository;
    ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarResponse> result = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car,GetAllCarResponse.class)).collect(Collectors.toList());

        return result;
    }

    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = modelMapperService.forRequest().map(request,Car.class);

        Car createdCar =  carRepository.save(car);

        CreatedCarResponse createdCarResponse =
                modelMapperService.forResponse().map(createdCar,CreatedCarResponse.class);

        return createdCarResponse;
    }
}
