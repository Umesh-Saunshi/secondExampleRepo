package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private String mobile;
    private String state;
    private String country;
    private String pinCode;
    private String password;
}
