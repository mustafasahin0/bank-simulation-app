package com.example.service.impl;


import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.enums.AccountStatus;
import com.example.enums.AccountType;
import com.example.mapper.AccountMapper;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
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
    public void createNewAccount(AccountDTO accountDTO) {

        accountDTO.setCreateDate(new Date());
        accountDTO.setAccountStatus(AccountStatus.ACTIVE);
        //we need to create Account object
//        AccountDTO accountDTO = new AccountDTO();
        //save into the database(repository)
        //return the object created
        accountRepository.save(accountMapper.convertToEntity(new AccountDTO()));
    }

    @Override
    public List<AccountDTO> listAllAccount() {
        List<Account> accountList = accountRepository.findAll();

        return accountList.stream().map(accountMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        //find the account object based on id
        Account account = accountRepository.findById(id).get();
        //set status to deleted
        account.setAccountStatus(AccountStatus.DELETED);
        //save the updated account object
        accountRepository.save(account);
    }

    @Override
    public void activateAccount(Long id) {
        //find the account belongs the id
        Account account = accountRepository.findById(id).get();
        //set status to active
        account.setAccountStatus(AccountStatus.ACTIVE);
        accountRepository.save(account);
    }

    @Override
    public AccountDTO retrieveById(Long id) {
        return accountMapper.convertToDTO(accountRepository.findById(id).get());
    }
}