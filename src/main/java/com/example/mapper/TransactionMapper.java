package com.example.mapper;

import com.example.dto.AccountDTO;
import com.example.dto.TransactionDTO;
import com.example.entity.Account;
import com.example.entity.Transaction;
import org.modelmapper.ModelMapper;

public class TransactionMapper {

    private final ModelMapper modelMapper;

    public TransactionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransactionDTO convertToDTO(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    public Transaction convertToEntity(TransactionDTO transactionDTO) {
        return modelMapper.map(transactionDTO, Transaction.class);
    }
}
