package com.ExpenseTracker.service;

import com.ExpenseTracker.entity.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);
}
