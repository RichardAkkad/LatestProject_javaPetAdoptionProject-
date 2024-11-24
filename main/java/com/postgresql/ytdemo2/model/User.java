package com.postgresql.ytdemo2.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="users")



public class User {

    @Id
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String Role;















}
