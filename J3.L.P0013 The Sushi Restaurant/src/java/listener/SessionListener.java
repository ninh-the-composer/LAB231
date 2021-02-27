/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author ninh
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int count = 0;
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update TotalViews set [view] = [view] + 1 where id = 1\n"
                + "select * from TotalViews";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("view");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        String format = "%1$06d";
        String result = String.format(format, count);
        String[] formatedCount = result.split("");
        se.getSession().setAttribute("count", formatedCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

}
