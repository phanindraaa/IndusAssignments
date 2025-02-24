package com.indus.project.service;

import com.indus.project.entity.Transaction;
import com.indus.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getUser().getUserId().equals(userId))
                .toList();
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
