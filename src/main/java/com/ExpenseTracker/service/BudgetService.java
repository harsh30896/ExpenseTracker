package com.ExpenseTracker.service;

import com.ExpenseTracker.dto.BudgetDto;
import com.ExpenseTracker.entity.BudgetEntity;

import java.util.List;

public interface BudgetService {
        List<BudgetEntity> setBudgetFor(List<BudgetDto> budgetEntity);
}
