/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package dao;

import entity.Article;
import java.util.List;

/**
 * This interface contain methods about Article
 * <code>java.lang.Exception</code> throws when error occurs
 * @author NinhTBMHE141325
 */
public interface IArticleDAO {
    
    /**
     * This method return an Article by inputted Id from Database.
     * @param id Primatives type integer, ID of article.
     * @return Specify Article with id inputted.
     * @throws Exception provide information about database access error.
     */
    public Article getArticleById(int id) throws Exception;

    /**
     * This method return top most recent Articles from Database, number of Article input by user.
     * @param top Number of Articles will return.
     * @return Top recent Articles from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Article> getArticles(int top) throws Exception;

    /**
     * This method return Articles searched from Database, those will display in an search page.
     * @param keyword Search keyword, input by user.
     * @param articlesAPage Number of Articles will display in an page.
     * @param page Number of page. Ex: 1, 2, 3...
     * @return List of Articles from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Article> search(String keyword, int articlesAPage, int page) throws Exception;

    /**
     * This method will return number of ALL articles has been searched by keyword from Database.
     * @param keyword Search keyword, input by user.
     * @return number of searched Article.
     * @throws Exception provide information about database access error.
     */
    public int getNumberResultsSearched(String keyword) throws Exception;
}
