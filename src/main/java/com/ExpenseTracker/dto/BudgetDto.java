package com.ExpenseTracker.dto;

import com.ExpenseTracker.enums.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
public class BudgetDto {
    private Category category;
    private Long amount;
}
