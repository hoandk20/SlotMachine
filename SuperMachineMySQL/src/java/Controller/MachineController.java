/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.playerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.player;

/**
 *
 * @author hoandk
 */
@WebServlet(name = "MachineController", urlPatterns = {"/Play"})
public class MachineController extends BaseLogin {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int checkWin(int a, int b, int c) {
        int win = 0;
        if (a == b && b == c) {
            return 2;
        }
        if (a == b || b == c || a == c) {
            return 1;
        }
        return 0;
    }
    String[] fruits = {"apple.png", "avocado.png", "cherry.png", "lemon.png", "megalon.png",
        "peach.png", "Banana.png", "coconut.png", "strawberry.png", "pineapple.png"};

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
    protected void ProcessGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            //if not reset after 15m
            if (timeAfter15m < new Date().getTime()) {
                reset = true;
            }
            //reset rank
            if (reset == true) {
                timeAfter15m = new Date().getTime();
                timeAfter15m = timeAfter15m + 900000;
                playerDAO pDAO = new playerDAO();
                listPlayer = new ArrayList<>();
                listPlayer = pDAO.getTop15();
                request.setAttribute("listPlayer", listPlayer);
                reset = false;
            } else {
                request.setAttribute("listPlayer", listPlayer);
            }

            request.setAttribute("n1", fruits[1]);
            request.setAttribute("n2", fruits[1]);
            request.setAttribute("n3", fruits[1]);
            request.getRequestDispatcher("SlotMachine.jsp").forward(request, response);
        }
    }
    ArrayList<player> listPlayer;
    long timeAfter15m;
    boolean reset = true;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void ProcessPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mess = "";
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            Random r = new Random();
            int number1 = r.nextInt(9);
            int number2 = r.nextInt(9);
            int number3 = r.nextInt(9);
            //smal win=1, big win = 2, lose =0
            int win = checkWin(number1, number2, number3);
            String name = "";
            int most = 0;
            int coin = 0;
            Cookie[] co = request.getCookies();
            for (Cookie cookie : co) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                }
                if (cookie.getName().equals("most")) {
                    most = Integer.parseInt(cookie.getValue());
                }
                if (cookie.getName().equals("coin")) {
                    coin = Integer.parseInt(cookie.getValue());
                    response.addCookie(cookie);
                }
            }

            coin = coin - 2;
            if (win == 2) {
                coin += 200;
                mess = "2";

            } else if (win == 1) {
                coin += 8;
                mess = "1";
            } else {
                mess = "0";
            }
            //load a structure of result image fruits and score for ajax request
            out.println(""
                    + "<div class=\"ajax\">\n"
                    + "<div class=\"cash\"><lable class=\"number\" id=\"num\" style=\"\">" + coin + "</lable><img class=\"coinx\" src=\"img/coinx.png\"alt=\"\"/></div>"
                    + "                    <img class=\"img1\" src=\"img/" + fruits[number1] + "\" alt=\"\"/>\n"
                    + "                    <img class=\"img2\" src=\"img/" + fruits[number2] + "\" alt=\"\"/>\n"
                    + "                    <img class=\"img3\" src=\"img/" + fruits[number3] + "\" alt=\"\"/>\n"
                    + "                    "
                    + "");
            if (mess.equals("1")) {
                out.println("<lable class=\"message\" id=\"mes\">You win and get 8<img class=\"coinx\" src=\"img/coinx.png\"alt=\"\"/></lable>");
            }
            if (mess.equals("2")) {
                out.println("<lable class=\"message\" id=\"mes\">You win a big prize with 200<img class=\"coinx\" src=\"img/coinx.png\"alt=\"\"/></lable>");
            }
            if (mess.equals("0")) {
                out.println("<lable class=\"message\" id=\"mes\">You Lose!</lable>");
            }
            out.print("</div>");
            if (most < coin) {
                playerDAO pDAO = new playerDAO();
                pDAO.updateCoin(name, coin);
            }
            Cookie c = new Cookie("coin", coin + "");
            c.setMaxAge(1800);
            response.addCookie(c);
            Cookie n = new Cookie("name", name);
            n.setMaxAge(1800);
            response.addCookie(n);
            Cookie m = new Cookie("most", most + "");
            m.setMaxAge(1800);
            response.addCookie(m);
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
