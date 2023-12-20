package com.etiya.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rentals")
public class Rental{
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "car_id")
    private int carId;
    @Column(name = "date_started")
    private LocalDateTime dateStarted;
    @Column(name = "rented_for_days")
    private int rentedForDays;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy="rental")
    private List<Payment> payments;
}
//Create a rental : DONE
//Only available cars can be rented : DONE

//Payment ->rentalId,price, creditcard info
//dont store credit card data in database
//simulate a bank service and check data : done
//if bank check true then create the rental