/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.ISocialDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Post;
import model.Social;

/**
 *
 * @author Ninh
 */
public class SocialDAO extends DBContext implements ISocialDAO {

    @Override
    public List<Social> getSocials() throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        List<Social> data = new ArrayList<>();
        String sql = "select * from Social";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String icon = rs.getString("icon");
                Social s = new Social(id, name, icon);
                data.add(s);
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

}
