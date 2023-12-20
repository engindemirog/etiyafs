package com.etiya.rentacar.adapters;

import com.etiya.rentacar.outServices.IsBankService;
import org.springframework.stereotype.Service;

@Service
public class IsBankPosServiceAdapter implements PosService{
    @Override
    public boolean pay(PaymentData paymentData) {
        IsBankService isBankService = new IsBankService();
        return isBankService.makePayment(paymentData.getCreditCardNumber(),paymentData.getCardHolder(),paymentData.getExpirationDate(), paymentData.getCvc(), paymentData.getAmount());
    }
}
