package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;
import com.etiya.rentacar.business.rules.payments.PaymentBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.PaymentRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import com.etiya.rentacar.entities.concretes.Payment;
import com.etiya.rentacar.outServices.IsBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    PaymentRepository paymentRepository;
    ModelMapperService modelMapperService;
    PaymentBusinessRules paymentBusinessRules;
    @Override
    public CreatedPaymentResponse add(CreatePaymentRequest request) {

        paymentBusinessRules.paymentResultFromPosShouldBeSuccessful(request);

        Payment payment = modelMapperService.forRequest().map(request,Payment.class);

        Payment createdPayment =  paymentRepository.save(payment);

        CreatedPaymentResponse createdPaymentResponse =
                modelMapperService.forResponse().map(createdPayment,CreatedPaymentResponse.class);

        return createdPaymentResponse;
    }
}
