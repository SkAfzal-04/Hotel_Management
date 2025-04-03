package com.code.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price_per_night")
    private double pricePerNight;

    @Column(name = "status", length = 20)
    private String status;

    // Default constructor
    public Room() {
    }

    // Parameterized constructor with all fields
    public Room(String roomNumber, String type, int capacity, double pricePerNight, String status) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    // Parameterized constructor for initial room setup (used in DataLoader)
    public Room(String roomNumber, String status) {
        this.roomNumber = roomNumber;
        this.type = "Standard";  // Default type
        this.capacity = 2;       // Default capacity
        this.pricePerNight = 100.0; // Default price
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
