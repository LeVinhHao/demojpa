package com.example.demojpa.entity;

import jakarta.persistence.*;

@Entity(name="sub_job")
//@IdClass(IdJobUsers.class)
public class JobUsers {
//    @Id
//    private int userId;
//
//    @Id
//    private int jobId;
    @EmbeddedId
    IdJobUsers idJobUsers;
}
