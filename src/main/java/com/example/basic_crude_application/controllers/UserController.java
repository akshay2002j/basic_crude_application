package com.example.basic_crude_application.controllers;

import com.example.basic_crude_application.entity.User;
import com.example.basic_crude_application.entity.UserDto;
import com.example.basic_crude_application.service.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    final private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
       User user = userService.getUserById(id);
       UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPhone());
       return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserById(@RequestParam Long id) {
         userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUserById(@RequestParam Long id, @RequestBody UserDto userDto) {
        userService.updateUserById(id,userDto);
        return new ResponseEntity<String>(  "User updated", HttpStatus.OK);
    }
}
