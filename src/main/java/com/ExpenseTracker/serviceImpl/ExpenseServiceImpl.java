package com.ExpenseTracker.serviceImpl;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.enums.Category;
import com.ExpenseTracker.repository.ExpenseRepo;
import com.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepo expenseRepo;

    @Override
    public ExpenseEntity addExpense(ExpenseEntity expenseEntity) {
        return expenseRepo.save(expenseEntity);
    }

    @Override
    public List<ExpenseEntity> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @Override
    public ExpenseEntity updateExpenses(Long expenseId, ExpenseEntity expenseEntity) {
        return expenseRepo.findById(expenseId)
                .map(expense -> {
                    expense.setAmount(expenseEntity.getAmount());
                    expense.setCategory(expenseEntity.getCategory());
                    expense.setDescription(expenseEntity.getDescription());

                    if (expenseEntity.getDate() != null) {
                        expense.setDate(expenseEntity.getDate());
                    }
                    return expenseRepo.save(expense);
                })
                .orElseThrow(() -> new RuntimeException("Expense not found with id " + expenseId));
    }


    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepo.deleteById(expenseId);}

    @Override
    public List<ExpenseEntity> getExpenseByCategory(Category category) {
          List<ExpenseEntity> getExpenCat = expenseRepo.findByCategory(category);
          return getExpenCat;
    }

    @Override
    public List<ExpenseEntity> findAll() {
        return expenseRepo.findAll();
    }


}
