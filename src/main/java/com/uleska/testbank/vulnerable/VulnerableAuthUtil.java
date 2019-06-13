package com.uleska.testbank.vulnerable;

import com.uleska.testbank.util.AuthUtil;

import javax.servlet.http.HttpServletRequest;

public class VulnerableAuthUtil implements AuthUtil {

    @Override
    public Boolean Authorized(HttpServletRequest request, String permission) {
        return true;
    }

}
