package com.code.api.services;

import com.code.api.entity.Room;
import com.code.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    RoomRepository roomRepo;

    @Override
    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> findAvailableRooms() {
        return roomRepo.findByStatus("available");
    }

    @Override
    public Room findById(int id) {
        Optional<Room> optional = roomRepo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Room save(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public String deleteById(int id) {
        roomRepo.deleteById(id);
        return "Room deleted successfully";
    }
}
