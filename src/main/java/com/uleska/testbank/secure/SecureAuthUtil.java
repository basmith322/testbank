package com.uleska.testbank.secure;

import com.uleska.authorization.AuthEngine;
import com.uleska.testbank.util.AuthUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecureAuthUtil implements AuthUtil {

    @Override
    public Boolean Authorized(HttpServletRequest request, String permission) {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        return AuthEngine.IsAuthorized(permission, role);
    }

}
