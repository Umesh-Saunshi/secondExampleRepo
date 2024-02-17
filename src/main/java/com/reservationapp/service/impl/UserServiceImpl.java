package com.reservationapp.service.impl;


import com.reservationapp.entity.User;
import com.reservationapp.payload.UserDto;
import com.reservationapp.repository.UserRepository;
import com.reservationapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository ;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){

        this.userRepository=userRepository;
    }

    @Override
    public UserDto createUser (UserDto userDto){
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    //convert dto to entity manually



    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setMobile(userDto.getMobile());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setPinCode(userDto.getPinCode());
        user.setPassword(userDto.getPassword());
        return user;

    }

    //convert Entity to Dto manually

    private  UserDto mapToDto (User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCity(user.getCity());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());
        userDto.setState(user.getState());
        userDto.setCountry(user.getCountry());
        userDto.setPinCode(user.getPinCode());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
