package com.example.service;

import com.example.dto.AccountDTO;
import com.example.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountService {

    AccountDTO createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId);

    List<AccountDTO> listAllAccount();

    void deleteAccount(Long id);

    void activateAccount(Long id);

    AccountDTO retrieveById(Long id);
}
