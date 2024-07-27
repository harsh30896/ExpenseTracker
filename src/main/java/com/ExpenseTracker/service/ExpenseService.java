package com.ExpenseTracker.service;

import com.ExpenseTracker.dto.ExpenseRequest;
import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.enums.Category;
import java.util.*;

public interface ExpenseService {
    ExpenseEntity addExpense(ExpenseRequest expenseRequest);
    List<ExpenseEntity> getAllExpenses();
    ExpenseEntity updateExpenses(Long expenseId,ExpenseEntity expenseEntity);
    void deleteExpense(Long expenseId);
    List<ExpenseEntity> getExpenseByCategory(Category category);
    List<ExpenseEntity> findAll();

}
