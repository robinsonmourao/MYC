package com.example.MYC.services;

import com.example.MYC.entities.User;
import com.example.MYC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser (String nome, String numMatricula) {

        Optional<User> user = userRepository.findByNumCadastro(numMatricula);

        // FAIL CASE
        if (!user.isEmpty()){
            throw new RuntimeException("User already exists!");
        }
        // SUCCESS CASE
        return user.get();
    }

    public User readUserByName (String name) {

        Optional<User> user = userRepository.findByName(name);

        // FAIL CASE
        if (user.isEmpty()){
            throw new RuntimeException("Inexistent User!");
        }
        // SUCCESS CASE
        return user.get();
    }

    public User readUserByNumCadastro (String numCadastro) {

        Optional<User> user = userRepository.findByNumCadastro(numCadastro);

        // FAIL CASE
        if (user.isEmpty()){
            throw new RuntimeException("Inexistent User!");
        }
        // SUCCESS CASE
        return user.get();
    }

    public User updateUser (User newUser) {

        Optional<User> previousUser = userRepository.findByNumCadastro(newUser.getNumCadastro());

        // FAIL CASE
        if (previousUser.isEmpty()){
            throw new RuntimeException("Inexistent User!");
        }
        // SUCCESS CASE
        userRepository.save(newUser);
        return newUser;
    }

    public User deleteUser (String numCadastro) {

        Optional<User> user = userRepository.findByNumCadastro(numCadastro);

        // FAIL CASE
        if (user.isEmpty()){
            throw new RuntimeException("Inexistent User!");
        }
        // SUCCESS CASE
        userRepository.delete(user.get());
        return user.get();
    }
}