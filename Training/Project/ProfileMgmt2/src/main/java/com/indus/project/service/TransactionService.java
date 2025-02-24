package com.indus.project.service;

import com.indus.project.entity.Transaction;
import com.indus.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PortfolioService portfolioService;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getUser().getUserId().equals(userId))
                .toList();
    }

    @Transactional
    public Transaction addTransaction(Transaction transaction) {
        // Save the transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Update portfolio shares if associated
        if (transaction.getPortfolio() != null) {
            portfolioService.updateShares(transaction.getPortfolio().getPortfolioId(), transaction);
        }

        return savedTransaction;
    }
}