package com.example.demojpa.service;

import com.example.demojpa.dto.RoleDTO;
import com.example.demojpa.entity.Roles;
import com.example.demojpa.repository.RolesRepository;
import com.example.demojpa.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RolesRepository rolesRepository;


    @Override
    public List<RoleDTO> getAllRole() {
        List<Roles> list=rolesRepository.findAll();
        List<RoleDTO> dtoList= new ArrayList<>();

        for(Roles data : list){
            RoleDTO roleDTO= new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());
            dtoList.add(roleDTO);
        }

        return dtoList;
    }

    @Override
    public List<RoleDTO> getRoleByName(String name) {
        List<Roles> list=rolesRepository.findByName(name);
        List<RoleDTO> dtoList= new ArrayList<>();

        for(Roles data : list){
            RoleDTO roleDTO= new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());
            dtoList.add(roleDTO);
        }

        return dtoList;
    }
}
