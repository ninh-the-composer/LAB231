/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package controller;

import dao.IArticleDAO;
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
 * This class supplies most Article information.<br>
 * @author NinhTBMHE141325
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/article"})
public class ArticleServlet extends HttpServlet {

   

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
            // Get id from url parameter.
            // If the parameter is not number, throw an Exception to user to show that article not found.
            int id = Integer.parseInt(request.getParameter("id"));
            IArticleDAO articleDao = new ArticleDAO();
            // Get 6 Articles most recent Articles.
            // Supplies for right banner top most recents Articles.
            List<Article> topArticles = articleDao.getArticles(6);
            // Get Article will display in main content.
            Article currentArticle = articleDao.getArticleById(id);
            // If Article doesn't exist, throw an Exception to user to show that article not found
            if(currentArticle == null) throw new Exception();
            // If current Article is one of 6 most Article on top, Remove from 6 most recent Articles.
            for(int i = 0; i < topArticles.size(); i++){
                if(topArticles.get(i).getId() == id){
                    topArticles.remove(i);
                }
            }
            // If current Article is not one of 6 most Article on top, Remove the last one.
            if(topArticles.size() != 5){
                topArticles.remove(5);
            }
            
            request.setAttribute("currentArticle", currentArticle);
            request.setAttribute("top5Articles", topArticles);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Article Not Found");
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
