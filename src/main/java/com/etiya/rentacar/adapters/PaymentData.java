package com.etiya.rentacar.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentData {
    private String creditCardNumber;
    private String cardHolder;
    private String expirationDate;
    private int cvc;
    private double amount;
}
