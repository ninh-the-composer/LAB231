/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    Integer getPostAPage(){
        try {
            InitialContext init = new InitialContext();
            Context cont = (Context) init.lookup("java:/comp/env");
            return Integer.parseInt((String) cont.lookup("postAPage"));
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return null;
    }
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
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt( request.getParameter("page"));
        int postAPage = getPostAPage();
        PostDAO postDao = new PostDAO();
        SocialDAO socialDao = new SocialDAO();
        
        List<Post> postList = postDao.getPosts(page, postAPage);
        
        int totalPost = postDao.countPosts();
        List<Integer> pages = new ArrayList<>();
        for(int i = 1, j = 0; j < totalPost; i++, j+=postAPage){
            pages.add(i);
        }
        
        List<Social> socialList = socialDao.getSocials();
        
        request.setAttribute("postList", postList);
        request.setAttribute("socialList", socialList);
        request.setAttribute("pages", pages);
        request.setAttribute("totalPost", totalPost);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
