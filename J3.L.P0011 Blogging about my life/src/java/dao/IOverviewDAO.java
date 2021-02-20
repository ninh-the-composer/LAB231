/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import model.Post;

/**
 *
 * @author sogor
 */
public interface IOverviewDAO {
    public HashMap<String, List<Post>> getGroupedPosts() throws Exception;
}
