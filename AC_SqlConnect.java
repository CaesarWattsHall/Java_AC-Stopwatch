/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stop;
import java.sql.*;
import java.sql.Connection;

public class SqlConnect {

    Connection conn = null;
    static final String MY_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    static String tableName = "ACRecords";

    public static Connection ConnectDB() {
//load the driver
        try {
            Class.forName(MY_DRIVER);
            System.out.println("Driver found!");
            String database = "jdbc:ucanaccess://C:\\Users\\TEMP\\Desktop\\ACStopWatchDB1.accdb";
            Connection conn = DriverManager.getConnection(database);
            Statement s = conn.createStatement();// use PreparedStatement in professional code INSTEAD OF Statement

// get table
            String insertStatementSQL = "Insert INTO" +tableName+"VALUES(acDstr)";
            s.execute(insertStatementSQL);
            System.out.println("Next Execute!");
            s.close();
            conn.close();
        } catch (Exception ex) {
        } finally {
        }
        return null;
    }
}
