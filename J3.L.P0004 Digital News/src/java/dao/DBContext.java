/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MADE-IN-HEAVEN
 */
public class DBContext {
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "J3.L.P0004";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";
    
    public void closeConntection(Connection con){
        try {
            if(con == null || con.isClosed())
                return;
            con.close();
        } catch (SQLException ex) {
        }
    }
    public void closePreparedStatement(PreparedStatement ps){
        try {
            if(ps == null || ps.isClosed())
                return;
            ps.close();
        } catch (SQLException ex) {
        }
    }
    public void closeResultSet(ResultSet rs){
        try {
            if(rs == null || rs.isClosed())
                return;
            rs.close();
        } catch (SQLException ex) {
        }
    }
}
