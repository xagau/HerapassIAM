package org.primefaces.rain.util;

import org.primefaces.rain.dao.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseConnectivityTest {
    public static void main(String[] args){
        Connection connection = DatabaseManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM projects limit 1");
            stmt.executeUpdate();
            stmt.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }  finally {
            Utility.closeQuietly(connection, null, null);
        }

    }
}
