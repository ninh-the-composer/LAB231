/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IPostscriptDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Post;
import model.Postscript;

/**
 *
 * @author Ninh
 */
public class PostscriptDAO extends DBContext implements IPostscriptDAO{
    @Override
    public Postscript getPostcript() throws Exception{
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        Postscript postscript = null;
        String sql = "select * from [About Me]";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String content = rs.getString("content");
                String author = rs.getString("author");
                postscript = new Postscript(content, author);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return postscript;
    }
}
