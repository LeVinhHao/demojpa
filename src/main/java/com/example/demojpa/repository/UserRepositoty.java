package com.example.demojpa.repository;

import com.example.demojpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepositoty extends JpaRepository<Users,Integer> {
    List<Users> findByEmailAndPassword(String email, String password);
    //Day la cau query viet bang JPQL cau query nay se tuong tac voi class entity
    @Query("select a from users as a")
    List<Users> getAllUsers();

    @Query("select u from users u join roles r on u.roles.id = r.id where u.email = ?1 and r.name=?2")
    List<Users> getUsersByEmailAndRoleName(String email, String roleName);
}
