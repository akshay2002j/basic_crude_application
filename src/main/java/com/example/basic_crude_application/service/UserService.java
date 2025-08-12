package com.example.basic_crude_application.service;

import com.example.basic_crude_application.entity.User;

public interface UserService {

    String createUser(User user);
    User getUserById(Long id);
}
