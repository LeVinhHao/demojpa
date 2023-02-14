package com.example.demojpa.service.imp;

import com.example.demojpa.dto.UserDTO;
import com.example.demojpa.entity.Users;
import com.example.demojpa.payload.LoginRequest;


import java.util.List;

public interface UserService {
    boolean login(LoginRequest loginRequest);
    boolean addUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    List<UserDTO> getUserByEmailAndRoleName(String email, String roleName);
}
