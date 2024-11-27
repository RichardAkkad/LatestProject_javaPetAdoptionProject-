package com.postgresql.ytdemo2.model;


import com.postgresql.ytdemo2.Enums.Role;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="users")



public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Add this line to auto-generate IDs
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private Role role;















}
