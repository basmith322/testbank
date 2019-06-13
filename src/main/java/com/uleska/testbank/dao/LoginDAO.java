package com.uleska.testbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for Database Interaction with the Login table.
 *
 * @author GR
 */
public class LoginDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public LoginDAO() {
        super();
    }

    /**
     * @param name name of the user to get the role for.
     * @return role
     */
    public String getRole(String name) {
        try {
            String getRole = "SELECT role FROM public.testbank_login WHERE name = ?;";
            PreparedStatement mapUserToRole = connection.prepareStatement(getRole);
            mapUserToRole.setString(1, name);
            mapUserToRole.execute();
            ResultSet mappedRole = mapUserToRole.getResultSet();

            if (mappedRole.next()) {
                return mappedRole.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
