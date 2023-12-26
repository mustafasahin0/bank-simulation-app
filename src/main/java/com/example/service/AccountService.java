package com.example.service;

import com.example.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    void createNewAccount(AccountDTO accountDTO);

    List<AccountDTO> listAllAccount();

    void deleteAccount(Long id);

    void activateAccount(Long id);

    AccountDTO retrieveById(Long id);

    List<AccountDTO> listAllActiveAccount();

    void updateAccount(AccountDTO accountDTO);
}
