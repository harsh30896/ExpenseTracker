package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.ExpenseRequest;
import com.ExpenseTracker.entity.ExpenseEntity;
import com.ExpenseTracker.entity.UserEntity;
import com.ExpenseTracker.enums.Category;
import com.ExpenseTracker.repository.ExpenseRepo;
import com.ExpenseTracker.service.EmailService;
import com.ExpenseTracker.service.ExpenseService;
import com.ExpenseTracker.utility.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @Autowired
    ExpenseRepo expenseRepo;

    @Autowired
    EmailService emailService;


    @PostMapping("/createExpenses")
    public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseRequest expenseRequest) {
        ExpenseEntity createExpen = expenseService.addExpense(expenseRequest);
        return new ResponseEntity<>(createExpen, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ExpenseEntity updateExpense(@PathVariable Long id, @RequestBody ExpenseEntity expenseEntity) {
        return expenseService.updateExpenses(id, expenseEntity);
    }

    @GetMapping("/export")
    public ResponseEntity<StreamingResponseBody> exportToCsv() {
        List<ExpenseEntity> expenses = expenseService.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=expenses.csv");

        StreamingResponseBody stream = outputStream -> {
            try (Writer writer = new OutputStreamWriter(outputStream)) {
                CSVHelper.writeExpensesToCsv(writer, expenses);
            } catch (IOException e) {
                throw new RuntimeException("Failed to write CSV", e);
            }
        };

        return new ResponseEntity<>(stream, headers, HttpStatus.OK);
    }

    @PostMapping("/getCategory/{category}")
    public List<ExpenseEntity> viewByCategory(@PathVariable Category category) {
        List<ExpenseEntity> getByCategory = expenseService.getExpenseByCategory(category);
        return getByCategory;
    }

    @GetMapping("/allResponses")
    public List<ExpenseEntity> getAllResponses() {
        List<ExpenseEntity> allResponses = expenseService.getAllExpenses();
        System.out.println(allResponses);
        return allResponses;
    }

    @PutMapping("/payBills")
    public ResponseEntity<String> payBills(@RequestParam(name = "Category") Category category,
                                           @RequestParam(name = "MaximumAmount") Double payment,
                                           @RequestParam(name = "userId") Long userId) {

        return expenseRepo.findByCategoryAndUserId(category, userId)
                .map(expense -> {
                    Double savedMaxAmt = expense.getAmount();

                    if (payment > savedMaxAmt) {
                         emailService.sendSimpleEmail("hpandey30896@gmail.com", "Excess Payment",
                               "Dear user, you are surpassing the payment limit while making this transaction");
                        return ResponseEntity.badRequest().body("Payment cannot be made");
                    }

                    expense.setAmount(savedMaxAmt - payment);
                    expenseRepo.save(expense);

                     emailService.sendSimpleEmail("hpandey30896@gmail.com", "Payment Made",
                        "Dear user, payment made for your current transaction");
                    return ResponseEntity.ok("Payment made successfully");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found"));
    }
}
