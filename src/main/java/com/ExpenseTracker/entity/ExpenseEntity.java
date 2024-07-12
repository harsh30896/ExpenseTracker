package com.ExpenseTracker.entity;


import com.ExpenseTracker.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
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
        @JoinColumn(name = "userId", nullable = false)
        private User user;

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Long getExpenseId() {
                return expenseId;
        }

        public void setExpenseId(Long expenseId) {
                this.expenseId = expenseId;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getAmount() {
                return amount;
        }

        public void setAmount(double amount) {
                this.amount = amount;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public Category getCategory() {
                return category;
        }

        public void setCategory(Category category) {
                this.category = category;
        }


}
