/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Owner
 */

import java.sql.*;

public class Database {
/**
* 
* @param args the command line arguments
*/

static final String MY_DRIVER="net.ucanaccess.jdbc.UcanaccessDriver";

static final String DB_USERNAME="";
static final String DB_PASSWORD="";
static String tableName ="StudentInfo";

public static void main(String[] args) {
// TODO code application logic here


try
{
//load the driver
Class.forName(MY_DRIVER);
System.out.println("Driver found!");
String database = "jdbc:ucanaccess://C:/Users/abena/OneDrive/Documents/NetBeansProjects/DatabaseExample/StudentDB.accdb";
Connection conn = DriverManager.getConnection(database,DB_USERNAME,DB_PASSWORD);
Statement s = conn.createStatement();// use PreparedStatement in professional code INSTEAD OF Statement
 

// get table
String selectStatementSQL = "SELECT * FROM " + tableName;
s.execute(selectStatementSQL);
ResultSet rs = s.getResultSet();
while((rs!=null) && (rs.next()))
{
System.out.println(rs.getString(1) + " : " + rs.getString(2));
}

System.out.println("Next Execute!");
//update a record
Statement s2 = conn.createStatement();// use PreparedStatement in professional code INSTEAD OF Statement
String updateStatementSQL="UPDATE "+tableName+" SET FirstName= 'Anthony' WHERE ID=7;" ;
s2.execute(updateStatementSQL);
ResultSet rs2 = s2.getResultSet();
while((rs2!=null) && (rs2.next()))
{
System.out.println(rs2.getString(1) + " : " + rs2.getString(2));
}


// pstmt.setString(1, "");

// close and cleanup
s.close();
conn.close();
}
catch(Exception ex)
{
ex.printStackTrace();
}finally{


}
}

}