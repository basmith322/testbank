package com.uleska.testbank.dao;

import com.uleska.testbank.model.System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Database Interaction with the AdminValidator table.
 *
 * @author GR
 */
public class SystemDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public SystemDAO() {
        super();
    }


    /**
     * Get all the {@link AdminValidator} in the database table.
     *
     * @return A list of all {@link AdminValidator}
     */
    public List<System> getSystem() {
        List<System> sysList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_setting;");

            while (rs.next()) {
                System sys = new System();
                sys.setId(rs.getInt("id"));
                sys.setMachineName(rs.getString("machine_name"));
                sys.setValue(rs.getString("value"));
                sys.setSetting(rs.getString("setting"));
                sysList.add(sys);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sysList;
    }

}
