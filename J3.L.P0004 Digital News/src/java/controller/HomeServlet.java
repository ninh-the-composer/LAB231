/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package controller;

import dao.*;
import dao.impl.ArticleDAO;
import entity.Article;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * The class supplies most Article information use for display Home page.<br>
 * @author NinhTBMHE141325
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IArticleDAO articleDao = new ArticleDAO();
            // Get 6 most recent Articles include top 1 recent Article.
            List<Article> topArticles = articleDao.getArticles(6);
            // Get top 1 recent Article from 6 most recent Articles, then remove from 6.
            Article mostRecentArticle = topArticles.get(0);
            topArticles.remove(mostRecentArticle);
            
            request.setAttribute("currentArticle", mostRecentArticle);
            request.setAttribute("top5Articles", topArticles);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Homepage Not Found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
