package com.uleska.authorization;

import com.uleska.validators.UleskaException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class AuthDAO {

    private java.sql.Connection conn = null;

    public void SetConnection(java.sql.Connection newconn) throws UleskaException {
        if (newconn != null) {
            conn = newconn;
        } else {
            throw new UleskaException("SQL connection passed was null.");
        }
    }

    public int GetRole(String role) throws UleskaException {
        if (conn == null) {
            throw new UleskaException("Attempt to find role without an active connection.");
        }

        try {
            String getRole = "SELECT id FROM uleska_roles WHERE role_name = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(getRole);
            preparedStatement.setString(1, role);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new UleskaException("No role found for [" + role + "].");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UleskaException("Exception occured finding role [" + role + "].");
        }
    }

    public int GetResource(String resource) throws UleskaException {
        if (conn == null) {
            throw new UleskaException("Attempt to find resource without an active connection.");
        }

        try {
            String getResource = "SELECT id FROM uleska_authorization WHERE resource = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(getResource);
            preparedStatement.setString(1, resource);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new UleskaException("No resource found for [" + resource + "].");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UleskaException("Exception occured finding resource [" + resource + "].");
        }
    }

    public boolean CheckAuthorized(int resource, int role) throws UleskaException {
        if (conn == null) {
            throw new UleskaException("Attempt to find authorization without active connection.");
        }

        try {
            String getResource = "SELECT id FROM uleska_authorization_link WHERE resource_id = ? AND role_id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(getResource);
            preparedStatement.setInt(1, resource);
            preparedStatement.setInt(2, role);
            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UleskaException("Exception occured finding authorization for resource Id [" + resource + "] and role Id [" + role + "].");
        }
    }

}