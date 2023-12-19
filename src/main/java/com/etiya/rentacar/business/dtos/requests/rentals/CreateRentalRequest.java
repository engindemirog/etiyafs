package com.etiya.rentacar.business.dtos.requests.rentals;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private LocalDateTime dateStarted;
    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
}
