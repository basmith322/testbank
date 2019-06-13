package com.uleska.testbank.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 7065934789201103115L;

    private int id;
    private String name;
    private String type;
    private int balance;
    private String address;
    private int overdraft;
    private String date;

}
