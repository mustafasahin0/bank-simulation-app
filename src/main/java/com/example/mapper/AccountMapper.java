package com.example.mapper;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    private final ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccountDTO convertToDTO(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }

    public Account convertToEntity(AccountDTO accountDTO) {
        return modelMapper.map(accountDTO, Account.class);
    }
}
