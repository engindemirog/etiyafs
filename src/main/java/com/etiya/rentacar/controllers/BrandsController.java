package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @PostMapping
    public CreatedBrandResponse add(@RequestBody @Valid CreateBrandRequest request){
        return brandService.add(request);
    }

    @GetMapping()
    public ResponseEntity<List<GetAllBrandResponse>> getAll(){
        return ResponseEntity.ok(this.brandService.getAll());

    }

}
