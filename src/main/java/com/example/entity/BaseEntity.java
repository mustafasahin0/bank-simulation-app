package com.example.entity;

import jakarta.persistence.*;
import lombok.extern.java.Log;

import java.time.Instant;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP")
    private Date createDate;

    public void setCreateDate(Date createDate) {
        this.createDate = Date.from(Instant.now());
    }
}
