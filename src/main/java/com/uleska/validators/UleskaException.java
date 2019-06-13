package com.uleska.validators;

public class UleskaException extends Exception {

    private static final long serialVersionUID = 2807175103360773120L;
    private String message;

    public UleskaException() {
    }

    public UleskaException(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }

}

