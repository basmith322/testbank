package com.uleska.testbank.datavalidation;

import com.uleska.validators.UleskaException;

public interface DataValidators {

    void validateTestBankId(String id) throws UleskaException;

    void validateTestBankName(String name) throws UleskaException;

    void validateTestBankAddress(String address) throws UleskaException;

    void validateTestbankValue(String value) throws UleskaException;

    void validateTestbankSearchterm(String search) throws UleskaException;

    void validateTestbankOverdraft(String overdraft) throws UleskaException;

    void validateTestbankAccounttype(String accounttype) throws UleskaException;

}
