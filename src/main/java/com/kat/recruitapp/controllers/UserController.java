package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.services.UserService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@Api(tags = "User Management")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public UserDto registerUser(@Valid @RequestBody UserCredentialsDto userCredentialsDto) {
        return userService.saveUser(userCredentialsDto);
    }
}
