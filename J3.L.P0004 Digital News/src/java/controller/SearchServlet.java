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
 * The class supplies most Article information use for display Search page.<br>
 * @author NinhTBMHE141325
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
            // Get search keyword from url parameter.
            String keyword = request.getParameter("keyword");
            // Get number of Articles will display in a page from Initial Parameter in Context Parameters
            int articlesAPage = Integer.parseInt(getServletContext().getInitParameter("articlesAPage"));
            // Get page number from url parameter. If parameter is not number or not found, set page to default 1.
            int page = request.getParameter("page") == null ? 0 : Integer.parseInt(request.getParameter("page"));
            
            IArticleDAO articleAccessing = new ArticleDAO();
            // Get top 5 most recent Article supplies display in right banner
            List<Article> topArticles = articleAccessing.getArticles(5);
            // Get List of Articles will display in specify page and specify number of article a page by search keyword.
            List<Article> searchResult = articleAccessing.search(keyword, articlesAPage, page);
            
            // Maximum number of page website can to display to user.
            int maxPage = (int) Math.ceil(articleAccessing.getNumberResultsSearched(keyword) / ((double) articlesAPage));
            
            request.setAttribute("searchResult", searchResult);
            request.setAttribute("top5Articles", topArticles);
            request.setAttribute("maxPage", maxPage);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Search Page Not Found");
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
