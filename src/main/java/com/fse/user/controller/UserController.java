package com.fse.user.controller;

import com.fse.user.model.User;
import com.fse.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userService")
public class UserController {
    @Autowired
    public UserService userService;

    //@GetMapping(value="/user/{id}",consumes = "application/json", produces="application/json")
    @GetMapping(value="/user/{id}")
    public User getUserById(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Optional<User> user = userService.getUserById(id);
        return user.get();
        //return new ResponseEntity<>(user,headers, HttpStatus.OK);
    }

    @GetMapping(value="/user/byName/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        User user = new User();
        try {
            Optional<User>  userOpt = userService.getUserByName(name);
            if(userOpt.isPresent()) {
                user = userOpt.get();
            }
        }catch(Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<User>(user,headers, status);
    }

    @GetMapping(value="/users", produces="application/json")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
