package com.etiya.rentacar.business.dtos.requests.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
    private int rentalId;
    private double amount;
    private String creditCardNumber;
    private String cardHolder;
    private String expirationDate;
    private int cvc;
}
