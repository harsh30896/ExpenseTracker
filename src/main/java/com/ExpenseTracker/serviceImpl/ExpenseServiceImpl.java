package com.ExpenseTracker.serviceImpl;

import com.ExpenseTracker.dto.ExpenseRequest;
import com.ExpenseTracker.dto.ExpenseResponse;
import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import com.ExpenseTracker.exceptionHandler.ResourceNotFoundException;
import com.ExpenseTracker.repository.ExpenseRepo;
import com.ExpenseTracker.repository.UserRepo;
import com.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepo expenseRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ExpenseEntity addExpense(ExpenseRequest expenseRequest) {
        ExpenseEntity expenseEntity=new ExpenseEntity();
        expenseEntity.setAmount(expenseRequest.getAmount());
        expenseEntity.setDate(expenseRequest.getDate());
        expenseEntity.setDescription(expenseRequest.getDescription());
        expenseEntity.setCategory(expenseRequest.getCategory());
        UserEntity dbUser = userRepo.findById(expenseRequest.getUser().getUserId()).
                orElseThrow(()->new ResourceNotFoundException("User not found with following id = "+expenseRequest.
                        getUser().getUserId()));
        if(dbUser!=null){
            expenseEntity.setUser(expenseRequest.getUser());
        }
        ExpenseEntity savedExpenseEntity = expenseRepo.save(expenseEntity);
        savedExpenseEntity.getUser().setAge(dbUser.getAge());
        savedExpenseEntity.getUser().setName(dbUser.getName());
        savedExpenseEntity.getUser().setEmail(dbUser.getEmail());

        return savedExpenseEntity;
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
