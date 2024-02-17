package com.reservationapp.service;

import com.reservationapp.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser (UserDto userDto);
    List<UserDto> getAllUsers ();
    //UserDto getUserById(Long id);
   // UserDto updateUser (Long id , UserDto userDto);
   // UserDto deleteUser (Long id);
}
