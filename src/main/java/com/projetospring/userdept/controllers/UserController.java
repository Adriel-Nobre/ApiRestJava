package com.projetospring.userdept.controllers;

import com.projetospring.userdept.entities.User;
import com.projetospring.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> listaTodos(){
       return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User listaPorId(@PathVariable Long id){
       return repository.findById(id).get();
    }

    @PostMapping
    public User adicionaUser(@RequestBody User user){
        return repository.save(user);
    }
}
