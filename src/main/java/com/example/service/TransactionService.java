package com.example.service;

import com.example.model.Account;
import com.example.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creatationDate, String message);

    List<Transaction> findAllTransactions();

    List<Transaction> last10Transactions();
}
