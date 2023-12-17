package com.example.entity;

import com.example.enums.AccountStatus;
import com.example.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Getter
@Setter
public class Account extends BaseEntity {

    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
