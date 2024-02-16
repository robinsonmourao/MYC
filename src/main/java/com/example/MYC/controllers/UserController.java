package com.example.MYC.controllers;

import com.example.MYC.entities.User;
import com.example.MYC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/v1/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.createUser(user.getName(), user.getNumCadastro()), HttpStatus.CREATED);
        }catch (RuntimeException alreadyExistsException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(alreadyExistsException.getMessage());
        }
    }
//    @GetMapping("/users")
//    public ResponseEntity<User> readByName (@RequestBody String name){
//        try{
//            return new ResponseEntity<>(userService.readUserByName(name), HttpStatus.OK);
//        }catch (RuntimeException exception){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }

    @GetMapping("/users")
    public ResponseEntity<User> readByNumCadastro (@RequestParam String numCadastro){
        try{
            return new ResponseEntity<>(userService.readUserByNumCadastro(numCadastro), HttpStatus.OK);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/users")
    public ResponseEntity<Object> updateUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.deleteUser(user.getNumCadastro()), HttpStatus.OK);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
