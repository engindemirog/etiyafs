package com.etiya.rentacar.business.dtos.requests.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private int brandId;
    private int colorId;
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
}