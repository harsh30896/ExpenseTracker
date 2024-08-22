package com.ExpenseTracker.serviceImpl;

import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.repository.UserRepo;
import com.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity createUser(UserEntity user) {
       return userRepo.save(user);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }
}
