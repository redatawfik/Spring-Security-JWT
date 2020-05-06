package com.example.springsecutity.repository;

import com.example.springsecutity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();

        User user = new User("user", passwordEncoder.encode("123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("123"), "ADMIN", "ACCESS_TEST_1,ACCESS_TEST_2");
        User manager = new User("manager", passwordEncoder.encode("123"), "MANAGER", "ACCESS_TEST_1");

        List<User> users = Arrays.asList(user, admin, manager);

        userRepository.saveAll(users);
    }
}
