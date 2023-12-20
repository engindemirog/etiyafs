package com.etiya.rentacar.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface PosService {
    public boolean pay(PaymentData paymentData);
}
