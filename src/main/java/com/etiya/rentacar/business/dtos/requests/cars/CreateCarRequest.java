package com.etiya.rentacar.business.dtos.requests.cars;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    private int brandId;
    @NotNull
    private int colorId;
    @Min(1)
    @Max(30000)
    private double dailyPrice;
    private int modelYear;
    @Size(min = 2, max = 30)
    private String description;
    @NotNull
    @Min(1)
    @Max(3)
    private int state;
}