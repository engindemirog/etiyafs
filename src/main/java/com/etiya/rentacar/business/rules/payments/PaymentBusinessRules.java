package com.etiya.rentacar.business.rules.payments;

import com.etiya.rentacar.adapters.PaymentData;
import com.etiya.rentacar.adapters.PosService;
import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.outServices.IsBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentBusinessRules {
    PosService posService;
    ModelMapperService modelMapperService;
    public void paymentResultFromPosShouldBeSuccessful(CreatePaymentRequest request){

        PaymentData paymentData = modelMapperService.forResponse().map(request, PaymentData.class);
        var bankResult = posService.pay(paymentData);
        if (!bankResult){
            throw new BusinessException("Payment is unsuccessful");
        }
    }
}
