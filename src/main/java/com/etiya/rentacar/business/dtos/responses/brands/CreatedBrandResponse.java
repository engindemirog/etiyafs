package com.etiya.rentacar.business.dtos.responses.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBrandResponse {
    private int id;
    private String name;

}
