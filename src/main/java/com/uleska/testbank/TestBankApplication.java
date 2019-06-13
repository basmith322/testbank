package com.uleska.testbank;

import com.uleska.authorization.AuthEngine;
import com.uleska.testbank.secure.SecureAuthUtil;
import com.uleska.testbank.secure.SecureDataValidators;
import com.uleska.testbank.vulnerable.VulnerableAuthUtil;
import com.uleska.testbank.vulnerable.VulnerableDataValidators;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TestBankApplication extends SpringBootServletInitializer {

    //Don't convert to local as used by .jsp pages
    public static String version = "";

    public static void main(String[] args) {
        //If sees -Dsecure then uses a secure context
        if (System.getProperty("secure") != null) {
            version = "Secure";
            Context.setAuthUtil(new SecureAuthUtil());
            Context.setDataValidators(new SecureDataValidators());
        } else {
            version = "Vulnerable";
            Context.setAuthUtil(new VulnerableAuthUtil());
            Context.setDataValidators(new VulnerableDataValidators());
        }
        AuthEngine.LoadAuthorization();
        SpringApplication.run(TestBankApplication.class, args);
    }

}
