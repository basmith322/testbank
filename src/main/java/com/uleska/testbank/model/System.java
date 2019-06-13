package com.uleska.testbank.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class System implements Serializable {

    private static final long serialVersionUID = 7065934789201103115L;

    private int id;
    private String machineName;
    private String setting;
    private String value;

}
