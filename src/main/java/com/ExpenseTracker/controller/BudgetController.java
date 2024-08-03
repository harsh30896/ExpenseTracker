package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.BudgetDto;
import com.ExpenseTracker.entity.BudgetEntity;
import com.ExpenseTracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @PostMapping("/createBudget")
    public List<BudgetEntity> createBudgetFor(@RequestBody List<BudgetDto> budgetDtos){
        return budgetService.setBudgetFor(budgetDtos);
    }
}
