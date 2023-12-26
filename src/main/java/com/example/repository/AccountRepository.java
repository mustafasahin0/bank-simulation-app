package com.example.repository;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.enums.AccountStatus;
import com.example.exception.RecordNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    public List<Account> findAllByAccountStatus(AccountStatus accountStatus);


}