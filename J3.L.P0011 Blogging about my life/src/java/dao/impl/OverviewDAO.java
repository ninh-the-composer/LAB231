/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IOverviewDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Post;

/**
 *
 * @author sogor
 */
public class OverviewDAO implements IOverviewDAO {

    @Override
    public HashMap<String, List<Post>> getGroupedPosts() throws Exception {
        HashMap<String, List<Post>> groups = new HashMap<>();
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            con = dbc.getConnection();
            // Get group of date in all Posts
            ps = con.prepareStatement("select distinct CAST(year(created_at) as nvarchar) + '-' +  CAST(month(created_at) as nvarchar) [date] from Post");
            rs1 = ps.executeQuery();
            while (rs1.next()) {
                List<Post> list = new ArrayList<>();
                String date = rs1.getString("date");
                // Get Posts per group
                ps = con.prepareStatement("select * from Post where created_at like '" + date + "%'");
                rs2 = ps.executeQuery();
                while (rs2.next()) {
                    String id = rs2.getString("id");
                    String title = rs2.getString("title");
                    String type = rs2.getString("type");
                    String image_path = rs2.getString("image_path");
                    String content = rs2.getString("content");
                    String createdAt = rs2.getString("created_at");
                    Post p = new Post(id, title, type, image_path, content, createdAt);
                    list.add(p);
                }
                groups.put(convertDate(date), list);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs2);
            dbc.closeResultSet(rs1);
        }
        return groups;
    }

    private String convertDate(String date) {
        String[] datePart = date.split("-");
        return Month.of(Integer.parseInt(datePart[1])).name() + " " + datePart[0];
    }
}
