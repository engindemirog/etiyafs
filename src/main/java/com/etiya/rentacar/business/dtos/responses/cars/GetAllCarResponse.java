package com.etiya.rentacar.business.dtos.responses.cars;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {
    private int id;
    private int brandId;
    private int colorId;
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
}
