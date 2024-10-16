package com.restart.controller;


import com.restart.service.UserServiceImpl;
import com.restart.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    //Recupera la lista di tutti gli utenti
    @GetMapping("deb/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //Recupera l'utente autenticato
    @GetMapping("auth/authUser")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getAuthenticatedUser());
    }
}
