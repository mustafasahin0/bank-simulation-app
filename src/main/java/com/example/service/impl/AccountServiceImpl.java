package com.example.service.impl;


import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.enums.AccountStatus;
import com.example.enums.AccountType;
import com.example.mapper.AccountMapper;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId) {
        //we need to create Account object
//        AccountDTO accountDTO = new AccountDTO();
        //save into the database(repository)
        //return the object created
        return accountMapper.convertToDTO(accountRepository.save(new Account()));
    }

    @Override
    public List<AccountDTO> listAllAccount() {
        return accountRepository.findAll().stream().map(accountMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        //find the account belongs the id
        AccountDTO accountDTO = accountMapper.convertToDTO(accountRepository.findById(id).get());
        //set status to deleted
        accountDTO.setAccountStatus(AccountStatus.DELETED);
    }

    @Override
    public void activateAccount(Long id) {
        //find the account belongs the id
        AccountDTO accountDTO = accountMapper.convertToDTO(accountRepository.findById(id).get());
        //set status to active
        accountDTO.setAccountStatus(AccountStatus.ACTIVE);
    }

    @Override
    public AccountDTO retrieveById(Long id) {
        return accountMapper.convertToDTO(accountRepository.findById(id).get());
    }
}