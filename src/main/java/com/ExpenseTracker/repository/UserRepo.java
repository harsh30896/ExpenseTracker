package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserEntity,Long>{


}