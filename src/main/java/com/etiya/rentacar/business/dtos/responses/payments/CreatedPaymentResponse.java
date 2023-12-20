package com.etiya.rentacar.business.dtos.responses.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPaymentResponse {
    private int rentalId;
    private double amount;
}
