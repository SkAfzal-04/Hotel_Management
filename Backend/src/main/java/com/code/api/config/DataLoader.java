package com.code.api.config;

import com.code.api.entity.Room;
import com.code.api.entity.User;
import com.code.api.repository.RoomRepository;
import com.code.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadInitialUsers();
        loadInitialRooms();
    }

    private void loadInitialUsers() {
        if (userRepo.findAll().isEmpty()) {
            User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
            User staff = new User("staff", passwordEncoder.encode("staff123"), "STAFF");
            userRepo.saveAll(List.of(admin, staff));
        }
    }

    private void loadInitialRooms() {
        if (roomRepo.findAll().isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                Room room = new Room("Room " + i, "available");
                roomRepo.save(room);
            }
        }
    }
}
