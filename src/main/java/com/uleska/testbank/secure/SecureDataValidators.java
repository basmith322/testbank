package com.uleska.testbank.secure;

import com.uleska.testbank.vulnerable.VulnerableDataValidators;
import com.uleska.validators.EnumValidator;
import com.uleska.validators.LengthValidator;
import com.uleska.validators.RegexValidator;
import com.uleska.validators.UleskaException;

import java.util.ArrayList;

public class SecureDataValidators extends VulnerableDataValidators {

    @Override
    public void validateTestBankName(String name) throws UleskaException {
        if ((name == null) || name.isEmpty()) {
            throw new UleskaException("name not supplied in request.)");
        }

        RegexValidator.validateRegexInput(name, "^[a-zA-Z+ ]*$");
        LengthValidator.ValidateLength(4, 100, name);
    }

    @Override
    public void validateTestBankAddress(String address) throws UleskaException {
        if ((address == null) || address.isEmpty()) {
            throw new UleskaException("address not supplied in request.)");
        }

        RegexValidator.validateRegexInput(address, "^[a-zA-Z0-9, <>'+]*$");
        LengthValidator.ValidateLength(5, 100, address);
    }

    @Override
    public void validateTestbankSearchterm(String search) throws UleskaException {
        if ((search == null) || search.isEmpty()) {
            throw new UleskaException("Search value value not supplied in request.)");
        }

        RegexValidator.validateRegexInput(search, "^[a-zA-Z0-9:/. ]*$");
        LengthValidator.ValidateLength(1, 40, search);
    }

    @Override
    public void validateTestbankAccounttype(String accountType) throws UleskaException {
        if ((accountType == null) || accountType.isEmpty()) {
            throw new UleskaException("accounttype not supplied in request.");
        }

        ArrayList<String> validvalues = new ArrayList<>();
        validvalues.add("Checking");
        validvalues.add("ISA");
        validvalues.add("Savings");
        validvalues.add("Corporate");
        validvalues.add("nochanges");

        EnumValidator.validateEnumInput(accountType, validvalues);
        LengthValidator.ValidateLength(1, 9, accountType);
    }

}
