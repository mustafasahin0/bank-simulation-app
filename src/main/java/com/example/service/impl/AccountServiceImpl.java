package com.example.service.impl;


import com.example.dto.AccountDTO;
import com.example.enums.AccountStatus;
import com.example.enums.AccountType;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId) {
        //we need to create Account object
        AccountDTO accountDTO = new AccountDTO();
        //save into the database(repository)
        //return the object created
        return accountRepository.save(accountDTO);
    }

    @Override
    public List<AccountDTO> listAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        //find the account belongs the id
        AccountDTO accountDTO = accountRepository.findById(id);
        //set status to deleted
        accountDTO.setAccountStatus(AccountStatus.DELETED);
    }

    @Override
    public void activateAccount(Long id) {
        //find the account belongs the id
        AccountDTO accountDTO = accountRepository.findById(id);
        //set status to active
        accountDTO.setAccountStatus(AccountStatus.ACTIVE);
    }

    @Override
    public AccountDTO retrieveById(Long id) {
        return accountRepository.findById(id);
    }
}