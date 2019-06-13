package com.uleska.validators;

import java.util.ArrayList;

public class EnumValidator {

    public static void validateEnumInput(String input, ArrayList<String> validValues) throws UleskaException {
        if (validValues.indexOf(input) == -1) {
            throw new UleskaException("Target [" + input + "] does not exist in desired enum list.");
        }
    }

}

