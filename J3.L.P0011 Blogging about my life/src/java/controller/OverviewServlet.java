/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import dao.impl.*;
import java.io.IOException;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;
import model.Social;

/**
 *
 * @author Ninh
 */
@WebServlet(name = "OverviewServlet", urlPatterns = {"/overview"})
public class OverviewServlet extends HttpServlet {

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
            ISocialDAO socialDao = new SocialDAO();
            List<Social> socialList = socialDao.getSocials();
            IOverviewDAO postDao = new OverviewDAO();
            HashMap<String, List<Post>> posts = postDao.getGroupedPosts();
            request.setAttribute("posts", posts);
            request.setAttribute("socialList", socialList);
            request.getRequestDispatcher("overview.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("common/error.jsp").forward(request, response);

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
    }// </editor-fold>

}
