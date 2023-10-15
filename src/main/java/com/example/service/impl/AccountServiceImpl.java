package com.example.service.impl;

import com.example.enums.AccountStatus;
import com.example.enums.AccountType;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date creationDate, AccountType accountType, Long userID) {
        // We need to create Account object
        Account account = Account.builder().id(UUID.randomUUID()).userId(userID).balance(balance).creationDate(creationDate).accountType(accountType).userId(userID).accountStatus(AccountStatus.ACTIVE).build();
        // save into the database(repository)
        // return the object created
        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(UUID id) {
        accountRepository.findById(id).setAccountStatus(AccountStatus.DELETED);
    }

    @Override
    public void activateAccount(UUID id) {
        accountRepository.findById(id).setAccountStatus(AccountStatus.ACTIVE);

    }

    @Override
    public Account findAccountById(UUID id) {
        return accountRepository.findById(id);
    }
}
