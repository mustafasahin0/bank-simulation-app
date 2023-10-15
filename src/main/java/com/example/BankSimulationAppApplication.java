package com.example;

import com.example.enums.AccountType;
import com.example.model.Account;
import com.example.model.Transaction;
import com.example.service.AccountService;
import com.example.service.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BankSimulationAppApplication {

    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(BankSimulationAppApplication.class, args);

        // get account and transaction service beans
//        AccountService accountService = container.getBean(AccountService.class);
//        TransactionService transactionService = container.getBean(TransactionService.class);

        // create 2 accounts: sender and receiver
//        Account sender = accountService.createNewAccount(BigDecimal.valueOf(70), new Date(), AccountType.SAVING, 1L);
//        Account receiver = accountService.createNewAccount(BigDecimal.valueOf(50), new Date(), AccountType.SAVING, 2L);
//
//        accountService.listAllAccount().forEach(System.out::println);
//        transactionService.makeTransfer(sender, receiver, new BigDecimal(40), new Date(), "Transaction 1");
//
//        System.out.println("transactionService.findAllTransactions().get(0) = " + transactionService.findAllTransactions().get(0));
//        accountService.listAllAccount().forEach(System.out::println);
    }
}
