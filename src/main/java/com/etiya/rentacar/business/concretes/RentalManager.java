package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.rentals.CreatedRentalResponse;
import com.etiya.rentacar.business.rules.cars.CarBusinessRules;
import com.etiya.rentacar.business.rules.rentals.RentalBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.dataaccess.abstracts.RentalRepository;
import com.etiya.rentacar.entities.concretes.Car;
import com.etiya.rentacar.entities.concretes.Rental;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    RentalRepository rentalRepository;
    CarRepository carRepository;
    ModelMapperService modelMapperService;
    RentalBusinessRules rentalBusinessRules;
    PaymentService paymentService;

    @Override
    @Transactional
    public CreatedRentalResponse add(CreateRentalRequest request) {

        rentalBusinessRules.OnlyAvailableCarsCanBeRented(request.getCarId());

        Rental rental = modelMapperService.forRequest().map(request, Rental.class);

        Rental createdRental =  rentalRepository.save(rental);

        CreatePaymentRequest createPaymentRequest = modelMapperService.forResponse().map(request, CreatePaymentRequest.class);
        createPaymentRequest.setRentalId(createdRental.getId());
        createPaymentRequest.setAmount(request.getTotalPrice());
        paymentService.add(createPaymentRequest);

        Optional<Car> car = carRepository.findById(request.getCarId());
        car.get().setState(3);

        carRepository.save(car.get());

        CreatedRentalResponse createdRentalResponse =
                modelMapperService.forResponse().map(createdRental,CreatedRentalResponse.class);

        return createdRentalResponse;
    }
}
