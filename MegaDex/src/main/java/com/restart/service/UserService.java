package com.restart.service;

import com.restart.dto.UserDto;
import com.restart.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}