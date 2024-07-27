package com.ExpenseTracker.entity;
import com.ExpenseTracker.enums.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
public class ExpenseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long expenseId;
        private String description;
        private double amount;
        private Date date;
        @Enumerated(EnumType.STRING)
        private Category category;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private UserEntity user;

}
