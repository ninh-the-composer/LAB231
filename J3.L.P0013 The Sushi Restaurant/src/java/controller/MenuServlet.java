/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMenuDAO;
import dao.IPostDAO;
import dao.ISocialDAO;
import dao.impl.MenuDAO;
import dao.impl.SocialDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Menu;
import model.Social;

/**
 *
 * @author sogor
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/menu"})
public class MenuServlet extends HttpServlet {

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
            int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
            int menusAPage = Integer.parseInt(getServletContext().getInitParameter("menusAPage"));
            ISocialDAO socialDao = new SocialDAO();
            List<Social> socialList = socialDao.getSocials();
            IMenuDAO menuDao = new MenuDAO();
            List<Menu> menuList = menuDao.getMenus(menusAPage, page);
            
            int maxPage = (int) Math.ceil(menuDao.countMenus() / ((double) menusAPage));
            
            request.setAttribute("menuList", menuList);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("socialList", socialList);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
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
    }

}
