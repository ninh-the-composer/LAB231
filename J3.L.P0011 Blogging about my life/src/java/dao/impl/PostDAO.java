/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IPostDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Post;

/**
 *
 * @author Ninh
 */
public class PostDAO implements IPostDAO {

    @Override
    public int countPosts() throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "select count(*) [r] from Post ";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("r");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return count;
    }

    @Override
    public List<Post> getPosts(int page, int postAPage) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int start = (page - 1) * postAPage;
        start = start < 0 ? 0 : start;
        List<Post> data = new ArrayList<>();
        String sql = "select * from Post \n"
                + "order by id\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, postAPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String type = rs.getString("type");
                String image_path = rs.getString("image_path");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");
                Post p = new Post(id, title, type, image_path, content, createdAt);
                data.add(p);
            }
        } catch (Exception e) {
            data = null;
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return data;
    }

    @Override
    public Post getPost(String id) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        String sql = "select * from post where id = ?";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String type = rs.getString("type");
                String image_path = rs.getString("image_path");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");
                p = new Post(id, title, type, image_path, content, createdAt);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return p;
    }

}
