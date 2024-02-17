package com.reservationapp.controller;

import com.reservationapp.payload.UserDto;
import com.reservationapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService=userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
       UserDto user = userService.createUser(userDto);
       return new ResponseEntity<>(user , HttpStatus.CREATED);

    }
}