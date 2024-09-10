package com.ExpenseTracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String age;
    private String email;
    private String contactNumber;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    @JsonManagedReference
    private List<ExpenseEntity> expenseEntity;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    @JsonManagedReference
    private List<BudgetEntity> budgetEntities;

}
