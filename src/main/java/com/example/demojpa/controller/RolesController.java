package com.example.demojpa.controller;


import com.example.demojpa.dto.RoleDTO;
import com.example.demojpa.entity.Roles;
import com.example.demojpa.repository.RolesRepository;

import com.example.demojpa.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RolesController {
    @Autowired
    RoleService roleService ;

    @GetMapping("")
    public ResponseEntity<?> getAllRole(){

        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name){

        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }
}
