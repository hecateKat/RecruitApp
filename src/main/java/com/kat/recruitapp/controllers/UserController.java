package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@Api(tags = "User Management")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/{id}")
//    @ApiOperation("Get user by ID")
//    public Optional<UserDto> getUser(@RequestParam UUID id){
//        return userService.getUserById(id);
//    }

    @PostMapping("/register")
    @ApiOperation("Create new user")
    public UserDto saveUser (@RequestBody UserDto userDto){
        return userService.save(userDto);
    }



}
