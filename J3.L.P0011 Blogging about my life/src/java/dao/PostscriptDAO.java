/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Postscript;

/**
 *
 * @author Ninh
 */
public class PostscriptDAO extends DBContext{
    public Postscript getPostcript(){
        Postscript postscript = null;
        String sql = "select * from About_Me";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String content = rs.getString("content");
                String author = rs.getString("author");
                postscript = new Postscript(content, author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postscript;
    }
    public static void main(String[] args) {
        PostscriptDAO dao = new PostscriptDAO();
        System.out.println(dao.getPostcript());
    }
}
