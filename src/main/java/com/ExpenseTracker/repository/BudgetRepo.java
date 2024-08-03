package com.ExpenseTracker.repository;

import com.ExpenseTracker.entity.BudgetEntity;
import com.ExpenseTracker.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<BudgetEntity,Long> {
    BudgetEntity findByCategory(Category category);
}
