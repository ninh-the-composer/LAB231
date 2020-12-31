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
import model.Social;

/**
 *
 * @author Ninh
 */
public class SocialDAO extends DBContext{
    public List<Social> getSocials(){
        List<Social> data = new ArrayList<>();
        String sql = "select * from Social";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String icon = rs.getString("icon");
                Social s = new Social(id, name, icon);
                data.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            data = null;
        }
    return data;
    }
    
    public static void main(String[] args) {
        SocialDAO dao = new SocialDAO();
        System.out.println(dao.getSocials());
    }
}
