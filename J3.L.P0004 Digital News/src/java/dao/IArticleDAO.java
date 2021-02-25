/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Article;
import java.util.List;

/**
 *
 * @author sogor
 */
public interface IArticleDAO {
    public Article getArticleById(int id) throws Exception;
    public List<Article> getArticles(int top) throws Exception;
    public List<Article> search(String keyword, int articlesAPage, int page) throws Exception;
    public int getNumberResultsSearched(String keyword) throws Exception;
}
