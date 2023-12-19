package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    CarService carService;
    @GetMapping()
    public ResponseEntity<List<GetAllCarResponse>> getAll(){

        return ResponseEntity.ok(this.carService.getAll());
    }

    @PostMapping
    public CreatedCarResponse add(@RequestBody @Valid CreateCarRequest request){
        return carService.add(request);
    }
}
