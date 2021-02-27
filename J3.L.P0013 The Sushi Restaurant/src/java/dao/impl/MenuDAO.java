/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.IMenuDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Menu;

/**
 *
 * @author sogor
 */
public class MenuDAO implements IMenuDAO{

    @Override
    public List<Menu> getMenus(int postAPage, int page) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int start = (page - 1) * postAPage;
        start = start < 0 ? 0 : start;
        List<Menu> data = new ArrayList<>();
        String sql = "select * from Menu \n"
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
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                Menu m = new Menu(id, name, price, description);
                data.add(m);
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
    public int countMenus() throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "select count(*) [r] from Menu ";
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
    
}
