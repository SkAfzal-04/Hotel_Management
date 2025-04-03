package com.code.api.services;

import com.code.api.entity.Booking;
import com.code.api.entity.Room;
import com.code.api.entity.User;
import com.code.api.repository.BookingRepository;
import com.code.api.repository.RoomRepository;
import com.code.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Booking createBooking(Booking booking) {
        Room room = roomRepo.findById(booking.getRoom().getId()).orElseThrow(() -> new RuntimeException("Room not found"));
        if (!room.getStatus().equalsIgnoreCase("available")) {
            throw new RuntimeException("Room is not available");
        }
        room.setStatus("booked");
        roomRepo.save(room);
        booking.setStatus("confirmed");
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    @Override
    public String cancelBooking(int id) {
        Optional<Booking> bookingOpt = bookingRepo.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            Room room = booking.getRoom();
            room.setStatus("available");
            roomRepo.save(room);
            bookingRepo.deleteById(id);
            return "Booking cancelled successfully.";
        }
        return "Booking not found.";
    }

    @Override
    public String leaveRoom(int id) {
        Optional<Booking> bookingOpt = bookingRepo.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            Room room = booking.getRoom();
            room.setStatus("available");
            roomRepo.save(room);
            booking.setStatus("completed");
            bookingRepo.save(booking);
            return "Room left successfully.";
        }
        return "Booking not found.";
    }
}
