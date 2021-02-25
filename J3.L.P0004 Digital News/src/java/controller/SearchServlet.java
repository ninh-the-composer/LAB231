/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IArticleDAO;
import dao.impl.ArticleDAO;
import entity.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sogor
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    
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
            String keyword = request.getParameter("keyword");
            int articlesAPage = Integer.parseInt(getServletContext().getInitParameter("articlesAPage"));
            int page = request.getParameter("p") == null ? 0 : Integer.parseInt(request.getParameter("page"));
            IArticleDAO articleAccessing = new ArticleDAO();
            List<Article> topArticles = articleAccessing.getArticles(5);
            List<Article> searchResult = articleAccessing.search(keyword, articlesAPage, page);
            
            int maxPage = (int) Math.ceil(articleAccessing.getNumberResultsSearched(keyword) / ((double) articlesAPage));
            
            
            request.setAttribute("searchResult", searchResult);
            request.setAttribute("top5Articles", topArticles);
            request.setAttribute("maxPage", maxPage);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
