package com.uleska.testbank.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Transaction implements Serializable {

    private static final long serialVersionUID = 7065934789201103115L;

    private int id;
    private String name;
    private int amount;
    private int account;
    private String type;

}
