package com.ExpenseTracker.serviceImpl;

import com.ExpenseTracker.dto.BudgetDto;
import com.ExpenseTracker.entity.BudgetEntity;
import com.ExpenseTracker.enums.Category;
import com.ExpenseTracker.repository.BudgetRepo;
import com.ExpenseTracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetRepo budgetRepo;

    @Override
    public List<BudgetEntity> setBudgetFor(List<BudgetDto> budgetDto) {
        for (BudgetDto dto : budgetDto) {
            Optional<BudgetEntity> optionalBudget = Optional.ofNullable(budgetRepo.findByCategory(dto.getCategory()));
            BudgetEntity budget = optionalBudget.orElse(new BudgetEntity());
            budget.setCategory(dto.getCategory());
            budget.setAmount(dto.getAmount());
            budgetRepo.save(budget);
        }
        return budgetRepo.findAll();
    }
}
