package com.uleska.testbank.dao;

import com.uleska.testbank.model.Transaction;

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
public class TransactionsDAO extends DaoBase {

    /**
     * @see DaoBase#DaoBase()
     */
    public TransactionsDAO() {
        super();
    }


    /**
     * Get all the {@link AdminValidator} in the database table.
     *
     * @return A list of all {@link AdminValidator}
     */
    public List<Transaction> getTransactions() {
        List<Transaction> txns = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.testbank_txns;");

            while (rs.next()) {
                Transaction txn = new Transaction();
                txn.setId(rs.getInt("id"));
                txn.setName(rs.getString("name"));
                txn.setType(rs.getString("type"));
                txn.setAmount(rs.getInt("amount"));
                txn.setAccount(rs.getInt("account"));
                txns.add(txn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return txns;
    }

}
