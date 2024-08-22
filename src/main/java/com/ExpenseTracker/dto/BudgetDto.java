package com.ExpenseTracker.dto;

import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BudgetDto {
    private Category category;
    private Long amount;
    private UserEntity user;
}

