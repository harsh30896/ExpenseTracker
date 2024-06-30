package com.ExpenseTracker.serviceImpl;

import com.ExpenseTracker.entity.ExpenseEntity;
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
        return List.of();
    }

    @Override
    public void deleteExpenses() {

    }

    @Override
    public ExpenseEntity updateExpenses(Integer expenseId, ExpenseEntity expenseEntity) {
     Optional<ExpenseEntity> expenseEntityOptional = expenseRepo.findById(expenseId);
     if(! expenseEntityOptional.isPresent()){
            return  null;
        }
     ExpenseEntity existingEntity = expenseEntityOptional.get();
        existingEntity.s

    }


}
