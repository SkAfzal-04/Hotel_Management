package com.code.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.api.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
