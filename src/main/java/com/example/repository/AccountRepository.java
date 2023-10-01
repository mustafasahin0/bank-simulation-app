package com.example.repository;

import com.example.exception.RecordNotFoundException;
import com.example.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {

    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account) {
        accountList.add(account);
        return account;
    }

    public List<Account> findAll() {
        return accountList;
    }

    public void findById(UUID id) {
        accountList.stream().filter(each -> each.getId().equals(id)).findFirst().orElseThrow(() -> new RecordNotFoundException("Account not found in DB"));
    }
}
