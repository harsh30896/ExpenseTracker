package com.ExpenseTracker.dto;

import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
    private Long expenseId;
    private String description;
    private double amount;
    private Date date;
    private Category category;
    private UserEntity user;
}
