package com.ExpenseTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer expenseId;
        private String groceries;
        private String bills;
        private String commute;
        private String electricity;
        private String rent;
        private String miscellaneous;

        public Integer getExpenseId() {
                return expenseId;
        }

        public void setExpenseId(Integer expenseId) {
                this.expenseId = expenseId;
        }

        public String getBills() {
                return bills;
        }

        public void setBills(String bills) {
                this.bills = bills;
        }

        public String getGroceries() {
                return groceries;
        }

        public void setGroceries(String groceries) {
                this.groceries = groceries;
        }

        public String getCommute() {
                return commute;
        }

        public void setCommute(String commute) {
                this.commute = commute;
        }

        public String getElectricity() {
                return electricity;
        }

        public void setElectricity(String electricity) {
                this.electricity = electricity;
        }

        public String getRent() {
                return rent;
        }

        public void setRent(String rent) {
                this.rent = rent;
        }

        public String getMiscellaneous() {
                return miscellaneous;
        }

        public void setMiscellaneous(String miscellaneous) {
                this.miscellaneous = miscellaneous;
        }
}
