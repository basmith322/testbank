package com.uleska.testbank.vulnerable;

import com.uleska.testbank.datavalidation.DataValidators;
import com.uleska.validators.LengthValidator;
import com.uleska.validators.RegexValidator;
import com.uleska.validators.UleskaException;

public class VulnerableDataValidators implements DataValidators {

    @Override
    public void validateTestBankId(String id) throws UleskaException {
        if ((id == null) || id.isEmpty()) {
            throw new UleskaException("Id value not supplied in request.");
        }

        RegexValidator.validateRegexInput(id, "^\\d+$");
        LengthValidator.ValidateLength(1, 4, id);
    }

    @Override
    public void validateTestBankName(String name) throws UleskaException {

    }

    @Override
    public void validateTestBankAddress(String address) throws UleskaException {

    }

    @Override
    public void validateTestbankValue(String value) throws UleskaException {
        RegexValidator.validateRegexInput(value, "^[a-zA-Z0-9:/. ]*$");
        LengthValidator.ValidateLength(2, 40, value);
    }

    @Override
    public void validateTestbankSearchterm(String search) throws UleskaException {

    }

    @Override
    public void validateTestbankOverdraft(String overdraft) throws UleskaException {
        if ((overdraft == null) || overdraft.isEmpty()) {
            throw new UleskaException("overdraft not supplied in request.");
        }

        RegexValidator.validateRegexInput(overdraft, "^[0-9]*$");
        LengthValidator.ValidateLength(2, 5, overdraft);
    }

    @Override
    public void validateTestbankAccounttype(String accounttype) throws UleskaException {

    }

}
