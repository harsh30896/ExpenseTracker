package com.ExpenseTracker.controller;

import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.repository.UserRepo;
import com.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserEntity> newUserCreate(@RequestBody UserEntity userEntity){
        UserEntity user =  userService.createUser(userEntity);
       return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        List<UserEntity> getAll = userService.getAllUsers();
        return getAll;
    }
}
