package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Getter
@Setter
public class Transaction extends BaseEntity {

    @ManyToOne
    private Account sender;
    @ManyToOne
    private Account receiver;

    private BigDecimal amount;

    private String message;
}
