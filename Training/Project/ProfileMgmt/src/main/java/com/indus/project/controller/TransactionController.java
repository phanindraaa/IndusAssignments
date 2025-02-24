package com.indus.project.controller;

import com.indus.project.entity.Transaction;
import com.indus.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get transactions by user ID
    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }

    // Add a new transaction
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }
}
