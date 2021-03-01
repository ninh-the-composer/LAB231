/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IArticleDAO;
import entity.Article;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class supplies all method need to display an Article Page.<br>
 * The method implements IArticleDAO.<br>
 * The method will throw an object  of <code>java.lang.Exception</code> class.<br>
 * if there is any error occurring when searching or getting data.
 * @author NinhTBMHE141325
 */
public class ArticleDAO implements IArticleDAO {

    /**
     * This method return top most recent Articles from Database, number of
     * Article input by user.
     *
     * @param top Number of Articles will return.
     * @return Top recent Articles from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Article> getArticles(int top) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> listArticle = new ArrayList<>();
        String sql = "select ar.*, au.name [author] from Article ar inner join Author au on au.id = ar.author_id order by date desc";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String imagePath = rs.getString("image_path");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                Article a = new Article(id, title, imagePath, content, date, author);
                listArticle.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return listArticle;
    }

    /**
     * This method return Articles searched from Database, those will display in
     * an search page.
     *
     * @param keyword Search keyword, input by user.
     * @param articlesAPage Number of Articles will display in an page.
     * @param page Number of page. Ex: 1, 2, 3...
     * @return List of Articles from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Article> search(String keyword, int articlesAPage, int page) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int start = (page - 1) * articlesAPage;
        start = start < 0 ? 0 : start;
        List<Article> listArticle = new ArrayList<>();
        String sql = "select ar.*, au.name [author] from Article ar inner join Author au on au.id = ar.author_id where ar.title like ? \n"
                + "order by date desc\n"
                + "offset ? rows\n"
                + "fetch next ? rows only ";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword.trim() + "%");
            ps.setInt(2, start);
            ps.setInt(3, articlesAPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String imagePath = rs.getString("image_path");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                Article a = new Article(id, title, imagePath, content, date, author);
                listArticle.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return listArticle;
    }

    /**
     * This method return an Article by inputted Id from Database.
     *
     * @param id Primatives type integer, ID of article.
     * @return Specify Article with id inputted.
     * @throws Exception provide information about database access error.
     */
    @Override
    public Article getArticleById(int id) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = null;
        String sql = "select ar.*, au.name [author] from Article ar inner join Author au on au.id = ar.author_id where ar.id = ?";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String imagePath = rs.getString("image_path");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                article = new Article(id, title, imagePath, content, date, author);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            dbc.closeConntection(con);
            dbc.closePreparedStatement(ps);
            dbc.closeResultSet(rs);
        }
        return article;
    }

    /**
     * This method will return number of ALL articles has been searched by
     * keyword from Database.
     *
     * @param keyword Search keyword, input by user.
     * @return number of searched Article.
     * @throws Exception provide information about database access error.
     */
    @Override
    public int getNumberResultsSearched(String keyword) throws Exception {
        DBContext dbc = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int r = 0;
        String sql = "select count(*) r from Article where title like ?";
        try {
            con = dbc.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword.trim() + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                r = rs.getInt("r");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            dbc.closeResultSet(rs);
            dbc.closePreparedStatement(ps);
            dbc.closeConntection(con);
        }
        return r;
    }

}
