package com.example.service.impl;

import com.example.enums.AccountType;
import com.example.exception.AccountOwnerShipExpception;
import com.example.exception.BadRequestException;
import com.example.exception.InSufficientBalanceException;
import com.example.exception.UnderConstructionException;
import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Value("${under_construction}")
    private boolean underConstruction;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creatationDate, String message) {
        if (!underConstruction) {


        /*
             - If sender or receiver is null,
             - If sender and receiver are the same account?
             - If sender has enough balance to make transfer?
             - If both accounts are checking, if not one of them saving, it needs to be same userId
         */

            validateAccount(sender, receiver);
            checkAccountOwnerShip(sender, receiver);
            executeBalanceAndUpdateIfRequired(amount, sender, receiver);

            // make transfer

            Transaction transaction = Transaction.builder().amount(amount).sender(sender.getId()).receiver(receiver.getId()).createDate(creatationDate).message(message).build();
            return transactionRepository.save(transaction);
        } else {
            throw new UnderConstructionException("App is under construction, please try again later");
        }
    }

    private void executeBalanceAndUpdateIfRequired(BigDecimal amount, Account sender, Account receiver) {
        if (checkSenderBalance(sender, amount)) {
            // update sender and receiver balance
            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));
        } else {
            throw new InSufficientBalanceException("Sender has insufficient balance");
        }
    }

    private boolean checkSenderBalance(Account sender, BigDecimal amount) {
        // Verify sender has enough balance to send
        return sender.getBalance().compareTo(amount) >= 0;
    }

    private void checkAccountOwnerShip(Account sender, Account receiver) {
        /*
            - If one of the account is savings and user is not the same or else throw AccountOwnershipException
         */
        if ((sender.getAccountType().equals(AccountType.SAVING) || receiver.getAccountType().equals(AccountType.SAVING)) && !receiver.getUserId().equals(sender.getUserId())) {
            throw new AccountOwnerShipExpception("If one of the account is savings and user must be the same for both.");
        }
    }

    private void validateAccount(Account sender, Account receiver) {
        /*
            - If sender or receiver is null,
            - Does account ids are same?
            - Does account exists in the DB?
         */
        if (sender == null || receiver == null) {
            throw new BadRequestException("Sender or receiver cannot be null");
        }

        // if accounts are the same throw BadRequestException "Accounts needs to be different"
        if (sender.getId().equals(receiver.getId())) {
            throw new BadRequestException("Accounts needs to be different");
        }

        findAccountById(sender.getId());
        findAccountById(receiver.getId());
    }

    private void findAccountById(UUID id) {
        accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> last10Transactions() {
        return transactionRepository.findLast10Transactions();
    }
}
