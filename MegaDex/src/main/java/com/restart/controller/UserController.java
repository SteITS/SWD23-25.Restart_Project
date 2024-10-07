package com.restart.controller;

import com.restart.dto.UserDto;
import com.restart.service.UserServiceImpl;
import com.restart.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("usert")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*@GetMapping("usersbyid/{userId}")
    public ResponseEntity<?> getUserWithCards(@PathVariable int userId) {
        Optional<User> userOptional = userService.getUser(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
