package com.example.demojpa.controller;

import com.example.demojpa.dto.UserDTO;
import com.example.demojpa.payload.LoginRequest;
import com.example.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

   @PutMapping("")
    public  ResponseEntity<?>addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.addUser(userDTO),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> Login(@RequestBody LoginRequest loginRequest){

        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }
    @GetMapping("")
    public  ResponseEntity<?>getAllUser(){

       return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/getUserByEmailAndRoleName")
    public  ResponseEntity<?>getUserByEmailAndRoleName(@RequestParam("email") String email, @RequestParam("roleName") String roleName){

        return new ResponseEntity<>(userService.getUserByEmailAndRoleName(email,roleName),HttpStatus.OK);
    }
}
