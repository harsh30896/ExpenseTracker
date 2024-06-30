package com.ExpenseTracker.controller;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home/")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("create")
    public ExpenseEntity createExpense(@RequestBody ExpenseEntity expenseEntity){
        return expenseService.addExpense(expenseEntity);
    }

    @PostMapping("update/{id}")
    public ExpenseEntity updateExpense(@PathVariable Integer id,@RequestBody Product product){

    }
}
