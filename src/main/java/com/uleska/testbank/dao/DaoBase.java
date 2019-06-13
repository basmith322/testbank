package com.uleska.testbank.dao;

import com.uleska.testbank.util.DatabaseUtil;

import java.sql.Connection;

/**
 * Data Access Object superclass Base for holding the Database Connection used
 * by all DAO subclasses
 *
 * @author GR
 */
public class DaoBase {

    /**
     * The connection to the database
     */
    final Connection connection;

    /**
     * Constructor that creates a database connection, storing the connection
     * for each DAO Object to be reused. Uses a singleton pattern to either
     * create a connection or use the instance if its already connected
     */
    DaoBase() {
        connection = DatabaseUtil.getConnection();
    }

}
