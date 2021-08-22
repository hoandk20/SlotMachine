/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.playerDAO;
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
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String name = request.getParameter("name").trim();
        player p = new player();
        p.setCoin(100);
        p.setName(name);
        playerDAO pDAO = new playerDAO();
        player most = pDAO.getPlayerByName(name);
        if(most.getName()==null){
            pDAO.insert(name, 100);
            most.setName(name);
            most.setCoin(100);
        }
        
        Cookie mos = new Cookie("most", most.getCoin()+"");
        Cookie nam = new Cookie("name", p.getName());
        Cookie coi = new Cookie("coin", p.getCoin()+"");
        mos.setMaxAge(1800);
        nam.setMaxAge(1800);
        coi.setMaxAge(1800);
        response.addCookie(coi);
        response.addCookie(nam);
        response.addCookie(mos);
       // request.getSession().setAttribute("most", most.getCoin());
      //  request.getSession().setAttribute("player", p);
        response.sendRedirect("../Play");
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
