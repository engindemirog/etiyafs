package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarResponse> getAll();
    CreatedCarResponse add(CreateCarRequest request);
}


