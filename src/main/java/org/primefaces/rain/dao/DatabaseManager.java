
package org.primefaces.rain.dao;

/**
 * Copyright (c) 2023 HeraPass.com, Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.primefaces.rain.util.Utility;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author xagau
 */
public class DatabaseManager {

    static long calls = 0;

    static Lock lock = new ReentrantLock();

    static Connection source = null;

    public static Connection getConnection() {

        try {
            lock.lock();
            boolean verbose = false;
            calls++;
            try {
                Exception e = new Exception();
                StackTraceElement[] list = e.getStackTrace();
                String from = list[1].getClassName() + "." + list[1].getMethodName();
                if (verbose) {
                    System.out.println("Call###" + calls + " to getConnection() from: " + from);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                org.primefaces.rain.dao.DataSource ds = null;
                ds = org.primefaces.rain.dao.DataSource.getInstance();
                source = ds.getConnection();
                if (verbose) {
                    ComboPooledDataSource cpds = ds.getComboPooledDataSource();
                    System.out.println("num_connections: " + cpds.getNumConnectionsDefaultUser());
                    System.out.println("num_busy_connections: " + cpds.getNumBusyConnectionsDefaultUser());
                    System.out.println("num_idle_connections: " + cpds.getNumIdleConnectionsDefaultUser());
                }
                return source;
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PropertyVetoException ex) {
                ex.printStackTrace();
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void heartbeat() {
        Connection conn = null;
        try {
            conn = getConnection();
            try {
                Statement statement = conn.createStatement();
                ResultSet r = statement.executeQuery("select * from users limit 1;");
                r.close();
                statement.close();
            } catch(Exception ex) { } 
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Get Connection");
            Connection c = DatabaseManager.getConnection();
            System.out.println("Got Connection");
            if (c == null) {
                System.out.println("Connection null");
                System.exit(0);
            } else {
                //heartbeat();
            }
            try {
                System.out.println("" + c.isClosed());
                Statement stmt = c.createStatement();
                ResultSet r = stmt.executeQuery("SELECT * FROM users");
                int count = 0;
                while (r.next()) {
                    count++;
                    System.out.println("User Name:" + r.getString("username"));
                }
                if (count == 0) {
                    long snap = System.currentTimeMillis();
                    int n = stmt.executeUpdate("INSERT INTO users (username, password, first_name, last_name, email, phone, user_status ) values ('newuser" + snap + "@herapass.com', '" + Utility.hashString("password") + "', 'John', 'Smith', 'newuser" + snap + "@herapass.com','555-555-5555', 1 )");
                    System.out.println("INSERTED:" + n);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            } catch(Exception ex) {
                System.out.println("Unable to connect");
            }
        }
}
