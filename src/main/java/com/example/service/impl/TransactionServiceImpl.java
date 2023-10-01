package com.example.service.impl;

import com.example.model.Account;
import com.example.model.Transaction;
import com.example.service.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creatationDate, String message) {
        /*
             - If sender or receiver is null,
             - If sender and receiver are the same account?
             - If sender has enough balance to make transfer?
             - If both accounts are checking, if not one of them saving, it needs to be same userId
         */

        validateAccount(sender, receiver);

        // make transfer

        return null;
    }

    private void validateAccount(Account sender, Account receiver) {
        /*
            - If sender or receiver is null,
            - Does account ids are same?
            - Does account exists in the DB?
         */
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return null;
    }
}
