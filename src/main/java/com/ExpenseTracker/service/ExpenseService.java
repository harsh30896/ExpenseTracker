package com.ExpenseTracker.service;

import com.ExpenseTracker.entity.ExpenseEntity;

import javax.lang.model.type.IntersectionType;
import java.util.*;

public interface ExpenseService {
    ExpenseEntity addExpense(ExpenseEntity expenseEntity);
    List<ExpenseEntity> getAllExpenses();
    void deleteExpenses();
    ExpenseEntity updateExpenses(Integer expenseId,ExpenseEntity expenseEntity);
}
