package com.uleska.authorization;

import java.util.*;

public class AuthEngine {

    private static final Map<String, ArrayList<String>> authorization = new HashMap<>();

    public static void LoadAuthorization() {
        authorization.put("login", new ArrayList<>(Arrays.asList("admin", "banker", "leadbanker", "unauthenticated")));
        authorization.put("accounts", new ArrayList<>(Arrays.asList("banker", "leadbanker")));
        authorization.put("editaccount", new ArrayList<>(Arrays.asList("banker", "leadbanker")));
        authorization.put("saveaccount", new ArrayList<>(Arrays.asList("banker", "leadbanker")));
        authorization.put("searchaccounts", new ArrayList<>(Arrays.asList("banker", "leadbanker")));
        authorization.put("transactions", new ArrayList<>(Collections.singletonList("leadbanker")));
        authorization.put("logout", new ArrayList<>(Arrays.asList("admin", "banker", "leadbanker", "unauthenticated")));
        authorization.put("configuration", new ArrayList<>(Collections.singletonList("admin")));
        authorization.put("editconfig", new ArrayList<>(Collections.singletonList("admin")));
        authorization.put("saveconfig", new ArrayList<>(Collections.singletonList("admin")));
        authorization.put("system", new ArrayList<>(Collections.singletonList("admin")));
        authorization.put("saveaccount:overdraft", new ArrayList<>(Collections.singletonList("leadbanker")));
        authorization.put("saveaccount:type", new ArrayList<>(Collections.singletonList("leadbanker")));
    }

    public static boolean IsAuthorized(String resource, String role) {
        if (resource == null || role == null) {
            return false;
        }

        ArrayList<String> roles = authorization.get(resource);

        if (roles == null) {
            return false;
        }

        for (String allowedRole : roles) {
            if (allowedRole.equals(role)) {
                return true;
            }
        }

        return false;
    }

}