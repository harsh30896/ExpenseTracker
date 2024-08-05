package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.MaximumBudgetEntity;
import com.ExpenseTracker.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaximumBudgetRepo extends JpaRepository<MaximumBudgetEntity,Long> {
    MaximumBudgetEntity findByUserIdAndCategory(Long userId, Category category);
}
