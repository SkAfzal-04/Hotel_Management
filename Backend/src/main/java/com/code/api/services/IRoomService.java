package com.code.api.services;

import com.code.api.entity.Room;
import java.util.List;

public interface IRoomService {

    List<Room> findAll();

    List<Room> findAvailableRooms();

    Room findById(int id);

    Room save(Room room);

    String deleteById(int id);
}
