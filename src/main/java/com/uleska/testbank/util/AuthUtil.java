package com.uleska.testbank.util;

import javax.servlet.http.HttpServletRequest;

public interface AuthUtil {

    Boolean Authorized(HttpServletRequest request, String permission);

}
