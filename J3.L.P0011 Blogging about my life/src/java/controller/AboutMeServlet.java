/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.PostscriptDAO;
import dao.impl.SocialDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Postscript;
import model.Social;

/**
 *
 * @author Ninh
 */
@WebServlet(name = "AboutMeServlet", urlPatterns = {"/about-me"})
public class AboutMeServlet extends HttpServlet {

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
            SocialDAO socialDao = new SocialDAO();
            PostscriptDAO postscriptDao = new PostscriptDAO();

            List<Social> socialList = socialDao.getSocials();
            Postscript ps = postscriptDao.getPostcript();

            request.setAttribute("socialList", socialList);
            request.setAttribute("postscript", ps);
            request.getRequestDispatcher("about-me.jsp").forward(request, response);
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
