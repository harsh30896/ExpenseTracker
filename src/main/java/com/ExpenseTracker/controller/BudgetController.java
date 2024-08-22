package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.BudgetDto;
import com.ExpenseTracker.dto.CustomResponseEntity;
import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import com.ExpenseTracker.exceptionHandler.ResourceNotFoundException;
import com.ExpenseTracker.repository.ExpenseRepo;
import com.ExpenseTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BudgetController {


    @Autowired
    UserRepo userRepo;

    @Autowired
    ExpenseRepo expenseRepo;

    @PutMapping("/manageBudget")
    public CustomResponseEntity createBudgetFor(@RequestParam(name ="userId")Integer userId,
                                                @RequestParam(name = "Category")String category,
                                                @RequestParam(name = "MaximumAmount")Double amount){
        UserEntity userEntity = userRepo.findById(Long.valueOf(userId))
                .orElseThrow(()->new ResourceNotFoundException("User Id not found with id = "+userId));
        if(userEntity!= null){
            ExpenseEntity expenses =expenseRepo.findByUserAndCategory(userEntity, Category.valueOf(category.toUpperCase()));
            if(expenses != null){
                expenseRepo.save(expenses);
            }else{
                throw new ResourceNotFoundException("Data not found with category = "+category);
            }

        }
        return new CustomResponseEntity<>("true","your budget is updated for this category = "
                +category+"your new amount = "+amount,null);
    }
}
