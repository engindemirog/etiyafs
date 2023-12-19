package com.etiya.rentacar.business.dtos.responses.rentals;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedRentalResponse {
    private int id;
    private String carId;
    private LocalDateTime dateStarted;
    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
}
