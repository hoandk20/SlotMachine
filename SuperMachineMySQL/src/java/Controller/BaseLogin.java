/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.player;

/**
 *
 * @author hoandk
 */
public abstract class BaseLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        if (checkLogin(request)) {
            ProcessGet(request, response);
        } else {
            response.sendRedirect("../Login");
        }
    }

    private boolean checkLogin(HttpServletRequest request) {
        //  player p = (player) request.getSession().getAttribute("player");
        Cookie[] c = request.getCookies();
        //  return p != null;
        String name = "";
        if (c!= null) {
            for (Cookie cookie : c) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                }
            }
        }
        return name != "";
    }

    protected abstract void ProcessGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void ProcessPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

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
        if (checkLogin(request)) {
            ProcessPost(request, response);
        } else {
            response.sendRedirect("../Login");
        }
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
