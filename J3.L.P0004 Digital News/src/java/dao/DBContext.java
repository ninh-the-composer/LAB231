/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * This class contain informations to connect to MSSQL Server properties.
 *
 * @author NinhTBMHE141325
 */
public class DBContext {
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    /**
     * This method open connection to Database.
     * 
     * @return Connection of Database and Application.
     * @throws Exception 
     */
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
    
    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param con connection of application and Database.
     */
    public void closeConntection(Connection con){
        try {
            if(con == null || con.isClosed())
                return;
            con.close();
        } catch (SQLException ex) {
        }
    }
    
    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param ps prepared statement that was executed and not suppose to use.
     */
    public void closePreparedStatement(PreparedStatement ps){
        try {
            if(ps == null || ps.isClosed())
                return;
            ps.close();
        } catch (SQLException ex) {
        }
    }
    
    /**
     * This method close ResultSet, free system resources.
     *
     * @param rs a table of data representing a database result set.
     */
    public void closeResultSet(ResultSet rs){
        try {
            if(rs == null || rs.isClosed())
                return;
            rs.close();
        } catch (SQLException ex) {
        }
    }
}
