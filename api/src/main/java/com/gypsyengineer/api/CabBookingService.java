package com.gypsyengineer.api;

public interface CabBookingService {
    Booking bookRide(String pickUpLocation) throws BookingException;
}
