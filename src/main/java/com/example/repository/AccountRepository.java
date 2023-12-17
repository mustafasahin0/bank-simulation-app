package com.example.repository;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.exception.RecordNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

//    public static List<AccountDTO> accountDTOList = new ArrayList<>();
//
//    public AccountDTO save(AccountDTO accountDTO){
//        accountDTOList.add(accountDTO);
//        return accountDTO;
//    }
//
//    public List<AccountDTO> findAll() {
//        return accountDTOList;
//    }
//
//    public AccountDTO findById(Long id) {
//        //TASK
//        //complete the method, that find the account inside the list, if not
//        //throw RecordNotFoundException
//        return accountDTOList.stream().filter(account -> account.getId().equals(id))
//                .findAny().orElseThrow(()-> new RecordNotFoundException("Account does not exist in the database."));
//
//    }
}