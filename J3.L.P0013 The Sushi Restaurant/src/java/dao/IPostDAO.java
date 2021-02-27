/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Post;

/**
 *
 * @author sogor
 */
public interface IPostDAO {

    public List<Post> getPosts(int postAPage, int page) throws Exception;

    public int countPosts() throws Exception;

    public Post getPost(int id) throws Exception;
}
