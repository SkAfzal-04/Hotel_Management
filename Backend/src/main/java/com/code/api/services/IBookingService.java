package com.code.api.services;

import com.code.api.entity.Booking;
import java.util.List;

public interface IBookingService {

    Booking createBooking(Booking booking);
    
    List<Booking> findAll();

    String cancelBooking(int id);

    String leaveRoom(int id);

}
