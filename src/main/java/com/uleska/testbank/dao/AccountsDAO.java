package com.uleska.testbank.dao;

import com.uleska.testbank.model.Account;

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
public class AccountsDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public AccountsDAO() {
        super();
    }


    /**
     * Get all the {@link AdminValidator} in the database table.
     *
     * @return A list of all {@link AdminValidator}
     */
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_accounts;");

            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("id"));
                acc.setName(rs.getString("name"));
                acc.setType(rs.getString("type"));
                acc.setAddress(rs.getString("address"));
                acc.setBalance(rs.getInt("balance"));
                acc.setOverdraft(rs.getInt("overdraft"));
                acc.setDate(rs.getString("date"));
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public List<Account> searchAccounts(String searchterm) {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_accounts WHERE name like '%" + searchterm + "%';");

            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("id"));
                acc.setName(rs.getString("name"));
                acc.setType(rs.getString("type"));
                acc.setAddress(rs.getString("address"));
                acc.setBalance(rs.getInt("balance"));
                acc.setOverdraft(rs.getInt("overdraft"));
                acc.setDate(rs.getString("date"));
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public void UpdateOverdraft(String version_id, String overdraft_amt) {
        try {
            int id = Integer.parseInt(version_id);
            int overdraft = Integer.parseInt(overdraft_amt);

            String updateOverdraftSQL = "UPDATE public.testbank_accounts SET overdraft = ? WHERE public.testbank_accounts.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateOverdraftSQL);
            preparedStatement.setInt(1, overdraft);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateName(String version_id, String name) {
        try {
            int id = Integer.parseInt(version_id);

            String updateNameSQL = "UPDATE public.testbank_accounts SET name = ? WHERE public.testbank_accounts.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateAddress(String version_id, String address) {
        try {
            int id = Integer.parseInt(version_id);

            String updateAddressSQL = "UPDATE public.testbank_accounts SET address = ? WHERE public.testbank_accounts.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateAddressSQL);
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateAccountType(String version_id, String type) {
        try {
            int id = Integer.parseInt(version_id);

            String updateNameSQL = "UPDATE public.testbank_accounts SET type = ? WHERE public.testbank_accounts.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSQL);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
