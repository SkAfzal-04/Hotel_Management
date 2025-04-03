package com.code.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.api.entity.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByStatus(String status);
}
