package com.ExpenseTracker.entity;

import com.ExpenseTracker.enums.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class MaximumBudgetEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double maxAllowedAmount;
}
