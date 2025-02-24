package com.indus.project.test;

import com.indus.project.entity.Transaction;
import com.indus.project.entity.User;
import com.indus.project.repository.TransactionRepository;
import com.indus.project.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    private Transaction transaction;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUserId(1L);
        user.setUsername("john_doe");

        transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setTransactionType("BUY");
        transaction.setStockSymbol("AAPL");
        transaction.setQuantity(10);
        transaction.setPrice(150.0);
        transaction.setStatus("SUCCESS");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setUser(user);
    }

    @Test
    void testGetAllTransactions() {
        System.out.println("Running testGetAllTransactions...");
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction));

        List<Transaction> transactions = transactionService.getAllTransactions();
        assertEquals(1, transactions.size());
        assertEquals("AAPL", transactions.get(0).getStockSymbol());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void testGetTransactionsByUserId() {
        System.out.println("Running testGetTransactionsByUserId...");
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction));

        List<Transaction> transactions = transactionService.getTransactionsByUserId(1L);
        assertEquals(1, transactions.size());
        assertEquals("AAPL", transactions.get(0).getStockSymbol());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void testAddTransaction() {
        System.out.println("Running testAddTransaction...");
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        Transaction savedTransaction = transactionService.addTransaction(transaction);
        assertEquals("AAPL", savedTransaction.getStockSymbol());
        verify(transactionRepository, times(1)).save(transaction);
    }
}
