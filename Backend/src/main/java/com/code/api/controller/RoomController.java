package com.code.api.controller;

import com.code.api.entity.Room;
import com.code.api.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    IRoomService roomService;

    @GetMapping("/list")
    public List<Room> listRooms() {
        return roomService.findAll();
    }

    @GetMapping("/available")
    public List<Room> listAvailableRooms() {
        return roomService.findAvailableRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomService.findById(id);
    }

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.save(room);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable int id) {
        return roomService.deleteById(id);
    }
}
