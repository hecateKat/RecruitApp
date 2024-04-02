package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Optional<UserDto> getUser(@RequestParam UUID id){
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto saveUser (@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @DeleteMapping
    public void deleteUser (@RequestParam UUID id){
        userService.deleteUser(id);
    }
}
