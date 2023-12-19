package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rentals.CreatedRentalResponse;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest request);
}
