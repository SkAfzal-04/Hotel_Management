package com.code.api.controller;

import com.code.api.entity.User;
import com.code.api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "test")
    public String testingApi() {
        return "Welcome To Spring Boot API";
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteById(id);
    }
}
