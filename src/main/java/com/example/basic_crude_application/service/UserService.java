package com.example.basic_crude_application.service;

import com.example.basic_crude_application.entity.User;
import com.example.basic_crude_application.service.serviceImpl.UserServiceImpl;

public  interface UserService {

    String createUser(User user);
    User getUserById(Long id);
    String deleteUserById(Long id);
}
