package com.uleska.testbank.dao;

import com.uleska.testbank.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data Access Object for Database Interaction with the AdminValidator table.
 *
 * @author GR
 */
public class EditAccountDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public EditAccountDAO() {
        super();
    }

    /**
     * Get all the {@link AdminValidator} in the database table.
     *
     * @return A list of all {@link AdminValidator}
     */
    public Account getAccount(int id) {
        Account acc = new Account();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_accounts WHERE id = " + id + ";");
            acc.setId(id);

            while (rs.next()) {
                acc.setName(rs.getString("name"));
                acc.setType(rs.getString("type"));
                acc.setAddress(rs.getString("address"));
                acc.setBalance(rs.getInt("balance"));
                acc.setOverdraft(rs.getInt("overdraft"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acc;
    }

    public int updateOverdraft(int id, int overdraft) {
        try {
            String updateOverdraftSQL = "UPDATE public.testbank_accounts SET overdraft = ? where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateOverdraftSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, overdraft);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}