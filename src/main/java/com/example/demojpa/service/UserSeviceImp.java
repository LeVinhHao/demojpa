package com.example.demojpa.service;

import com.example.demojpa.dto.UserDTO;
import com.example.demojpa.entity.Roles;
import com.example.demojpa.entity.Users;
import com.example.demojpa.payload.LoginRequest;
import com.example.demojpa.repository.UserRepositoty;
import com.example.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSeviceImp implements UserService {
    @Autowired
    UserRepositoty userRepositoty;
    @Override
    public boolean login(LoginRequest loginRequest) {

        return  userRepositoty.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword()).size()>0;
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setFullName(userDTO.getFullName());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roles);
        try {
            userRepositoty.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> list= new ArrayList<>();
        for ( Users user :userRepositoty.getAllUsers()){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setFullName(user.getFullName());
            userDTO.setAvatar(user.getAvatar());
            userDTO.setRoleId(user.getId());
            list.add(userDTO);
        }
        return list;
    }

    @Override
    public List<UserDTO> getUserByEmailAndRoleName(String email, String roleName) {
        List<UserDTO> list= new ArrayList<>();
        for ( Users user :userRepositoty.getUsersByEmailAndRoleName(email,roleName)){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setFullName(user.getFullName());
            userDTO.setAvatar(user.getAvatar());
            userDTO.setRoleId(user.getId());
            list.add(userDTO);
        }
        return list;
    }

}
