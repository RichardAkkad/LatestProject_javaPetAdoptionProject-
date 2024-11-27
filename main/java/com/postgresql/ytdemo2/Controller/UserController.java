package com.postgresql.ytdemo2.Controller;


import com.postgresql.ytdemo2.model.User;
import com.postgresql.ytdemo2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   @Autowired
   UserRepo userRepo;

   @PostMapping("/signUp")
    public User createUser(@RequestBody User user ) {
       User user1 = userRepo.findByUsername(user.getUsername());
       if (user1 != null) {
           return null;
       }
       return userRepo.save(user);

   }



















}
