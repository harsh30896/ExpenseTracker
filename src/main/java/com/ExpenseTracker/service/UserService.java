package com.ExpenseTracker.service;

import com.ExpenseTracker.entity.UserEntity;
import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
