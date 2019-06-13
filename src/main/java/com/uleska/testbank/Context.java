package com.uleska.testbank;

import com.uleska.testbank.datavalidation.DataValidators;
import com.uleska.testbank.util.AuthUtil;

public class Context {

    private static AuthUtil authUtil;
    private static DataValidators dataValidators;

    public static AuthUtil getAuthUtil() {
        return authUtil;
    }

    public static void setAuthUtil(AuthUtil source) {
        authUtil = source;
    }

    public static DataValidators getDataValidators() {
        return dataValidators;
    }

    public static void setDataValidators(DataValidators source) {
        dataValidators = source;
    }

}
