package com.uleska.testbank.dao;

import com.uleska.testbank.model.Config;

import java.sql.PreparedStatement;
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
public class ConfigDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public ConfigDAO() {
        super();
    }


    /**
     * Get all the {@link AdminValidator} in the database table.
     *
     * @return A list of all {@link AdminValidator}
     */
    public List<Config> getConfig() {
        List<Config> configs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_config");

            while (rs.next()) {
                Config config = new Config();
                config.setId(rs.getInt("id"));
                config.setName(rs.getString("name"));
                config.setDescription(rs.getString("description"));
                config.setValue(rs.getString("value"));
                configs.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return configs;
    }

    public Config getConfig(int id) {
        Config config = new Config();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_config WHERE id = " + id);

            while (rs.next()) {
                config.setId(rs.getInt("id"));
                config.setName(rs.getString("name"));
                config.setValue(rs.getString("value"));
                config.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return config;
    }


    public void UpdateConfig(String version_id, String value) {
        try {
            int id = Integer.parseInt(version_id);

            String updateConfigSQL = "UPDATE public.testbank_config SET value = ? WHERE public.testbank_config.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateConfigSQL);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
