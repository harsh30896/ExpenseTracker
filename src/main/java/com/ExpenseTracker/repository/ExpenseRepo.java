package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Integer> {

}
