package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import com.etiya.rentacar.business.dtos.responses.rentals.CreatedRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController {
    RentalService rentalService;

    @PostMapping
    public CreatedRentalResponse add(@RequestBody @Valid CreateRentalRequest request){
        return rentalService.add(request);
    }
}
