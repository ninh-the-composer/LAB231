/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Post;

/**
 *
 * @author Ninh
 */
public class PostDAO extends DBContext {
    public int countPosts(){
        int count = 0;
        String sql = "select count(*) [r] from Post ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt("r");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<Post> getPosts(int page, int postAPage) {
        int start = (page - 1) * postAPage;
        start = start < 0 ? 0 : start;
        List<Post> data = new ArrayList<>();
        String sql = "select * from Post \n"
                + "order by id\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, postAPage);
            ResultSet rs = ps.executeQuery();
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
            e.printStackTrace();
            data = null;
        }
        return data;
    }
    
    public Post getPost(String id){
        Post p = null;
        String sql = "select * from post where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String type = rs.getString("type");
                String image_path = rs.getString("image_path");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");
                p = new Post(id, title, type, image_path, content, createdAt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    public static void main(String[] args) {
        PostDAO dao = new PostDAO();
        System.out.println(dao.getPost("2"));
    }
}
