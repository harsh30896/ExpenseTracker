package com.ExpenseTracker.service;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.enums.Category;
import java.util.*;

public interface ExpenseService {
    ExpenseEntity addExpense(ExpenseEntity expenseEntity);
    List<ExpenseEntity> getAllExpenses();
    ExpenseEntity updateExpenses(Long expenseId,ExpenseEntity expenseEntity);
    void deleteExpense(Long expenseId);
    List<ExpenseEntity> getExpenseByCategory(Category category);
    List<ExpenseEntity> findAll();
}
