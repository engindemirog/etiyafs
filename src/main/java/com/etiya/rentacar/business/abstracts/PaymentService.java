package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;
import com.etiya.rentacar.business.dtos.responses.rentals.CreatedRentalResponse;

public interface PaymentService {
    CreatedPaymentResponse add(CreatePaymentRequest request);
}
