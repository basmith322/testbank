package com.uleska.validators;

public class LengthValidator {

    public static void ValidateLength(int min, int max, String value) throws UleskaException {
        if (value.length() < min) {
            throw new UleskaException("Target [" + value + "] length [" +
                value.length() + "] less than minimum length [" + min + "].");
        }

        if (value.length() > max) {
            throw new UleskaException("Target [" + value + "] length [" +
                value.length() + "] greater than maximum length [" + max + "].");
        }
    }

}

