package com.code.api.controller;

import com.code.api.entity.Booking;
import com.code.api.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/list")
    public List<Booking> listBookings() {
        return bookingService.findAll();
    }

    @PutMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable int id) {
        return bookingService.cancelBooking(id);
    }

    @PutMapping("/leave/{id}")
    public String leaveRoom(@PathVariable int id) {
        return bookingService.leaveRoom(id);
    }
}
