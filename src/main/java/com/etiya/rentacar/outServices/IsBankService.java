package com.etiya.rentacar.outServices;

//thing that this is an endpoint
public class IsBankService {
    public boolean makePayment(String creditCardNumber, String cardHolder, String expirationDate, int cvc, double amount){
        if(amount>5000){
            return false;
        }

        return true;
    }
}
