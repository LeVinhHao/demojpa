package com.example.demojpa.repository;

import com.example.demojpa.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
    List<Roles> findByName(String name);
}
