package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByCategory(Category category);
    ExpenseEntity findByUserAndCategory(UserEntity user,Category category);

}
