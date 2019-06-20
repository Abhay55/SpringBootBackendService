package com.gfg.abhay.SpringBootBackendService.service;

import com.gfg.abhay.SpringBootBackendService.model.User;
import com.gfg.abhay.SpringBootBackendService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserDaoService {

    @Autowired
    private UserRepository userrepo;

    public List<User> findAllUsers(){

        ArrayList users=(ArrayList) userrepo.findAll();
        return (users);

    }


    public Optional<User> findUserById(Long id){

        Optional<User> user=userrepo.findById(id);
        return user;

    }

    public User createUser(User user){

        userrepo.save(user);
        return (user);
    }

    public User updateUser(User user){

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        userrepo.save(user);
        return user;
    }

    public void deleteUser(Long id){



        userrepo.deleteById(id);
    }



}
