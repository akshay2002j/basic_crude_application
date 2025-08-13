package com.example.basic_crude_application.service.serviceImpl;

import com.example.basic_crude_application.entity.User;
import com.example.basic_crude_application.entity.UserDto;
import com.example.basic_crude_application.repository.UserRepository;
import com.example.basic_crude_application.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created";
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }

    @Override
    public String updateUserById(Long id, UserDto user) {
      User savedUser =  userRepository.getUserById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
      savedUser.setUsername(user.username());
      savedUser.setEmail(user.email());
      savedUser.setPhone(user.phone());
      userRepository.save(savedUser);
        return "User updated";
    }

}
