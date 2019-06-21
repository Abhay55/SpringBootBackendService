package com.gfg.abhay.SpringBootBackendService.controller;

import com.gfg.abhay.SpringBootBackendService.model.User;
import com.gfg.abhay.SpringBootBackendService.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

   @GetMapping("/users")
    public List<User> getAllUsers(){
       ArrayList users=(ArrayList) userService.findAllUsers();
       return (users);
   }

   @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){

       Optional<User> user=userService.findUserById(id);
       return user;

       }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){

        userService.createUser(user);
        return user;
    }

    @PutMapping("/user")
    public User updateUserById(@RequestBody User user){

       userService.updateUser(user);
       return user;

   }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id){

       userService.deleteUser(id);

    }
}
