package com.uleska.testbank.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                InputStream inputStream = DatabaseUtil.class.getClassLoader().getResourceAsStream("db.properties");
                Properties prop = new Properties();
                prop.load(inputStream);

                Class.forName(prop.getProperty("driver"));
                connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

    public static List<Integer> getIntegerListFromSQLArray(ResultSet rs, String arrayColumnName) throws SQLException {
        List<Integer> psqlArrayArrayList = new ArrayList<>();
        java.sql.Array psqlArray = rs.getArray(arrayColumnName);

        if (psqlArray != null) {
            for (Object obj : (Object[]) psqlArray.getArray()) {
                try {
                    Integer arr = (Integer) obj;
                    psqlArrayArrayList.add(arr);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        return psqlArrayArrayList;
    }

}
