package com.ExpenseTracker.controller;

import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("home/")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @PostMapping("create")
    public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expenseEntity){
        ExpenseEntity createExpen = expenseService.addExpense(expenseEntity);
        return new ResponseEntity<>(createExpen, HttpStatus.CREATED);
    }

    @PostMapping("update/{id}")
    public ExpenseEntity updateExpense(@PathVariable Long id,@RequestBody ExpenseEntity expenseEntity){
        return expenseService.updateExpenses(id,expenseEntity);
    }
}
