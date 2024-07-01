package com.ExpenseTracker.service;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.enums.Category;
import org.springframework.http.ResponseEntity;

import javax.lang.model.type.IntersectionType;
import java.util.*;

public interface ExpenseService {
    ExpenseEntity addExpense(ExpenseEntity expenseEntity);
    List<ExpenseEntity> getAllExpenses();
    ExpenseEntity updateExpenses(Long expenseId,ExpenseEntity expenseEntity);
    void deleteExpense(Long expenseId);
    List<ExpenseEntity> getExpenseByCategory(Category category);
}
