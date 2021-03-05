package com.gypsyengineer.server;

import com.gypsyengineer.api.Booking;
import com.gypsyengineer.api.BookingException;
import com.gypsyengineer.api.CabBookingService;

import static java.lang.Math.random;
import static java.util.UUID.randomUUID;

public class CabBookingServiceImpl implements CabBookingService {

    @Override
    public Booking bookRide(String pickUpLocation) throws BookingException {
        if (random() < 0.3) {
            throw new BookingException("Cab unavailable");
        }
        return new Booking(randomUUID().toString());
    }
}
