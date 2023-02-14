package com.example.demojpa.service.imp;

import com.example.demojpa.dto.RoleDTO;
import com.example.demojpa.entity.Roles;
import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRole();
    List<RoleDTO>getRoleByName(String name);

}
