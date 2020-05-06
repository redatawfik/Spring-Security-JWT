package com.example.springsecutity.controller;

import com.example.springsecutity.model.User;
import com.example.springsecutity.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    private UserRepository userRepository;

    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("helloAll")
    public String greetingAll() {
        return "Hello All";
    }

    @GetMapping("helloUser")
    public String greetingUser() {
        return "Hello User";
    }

    @GetMapping("helloAdmin")
    public String greetingAdmin() {
        return "Hello Admin";
    }

    @GetMapping("helloManager")
    public String greetingManager() {
        return "Hello Manager";
    }

    @GetMapping("test1")
    public String test1() {
        return "test1";
    }

    @GetMapping("test2")
    public String test2() {
        return "test2";
    }
}
