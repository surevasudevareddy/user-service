package com.fse.user.service;

import com.fse.user.model.User;
import com.fse.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
       return userRepository.findById(id);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findFirstByName(name);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}