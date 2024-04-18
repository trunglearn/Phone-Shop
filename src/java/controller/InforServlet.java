/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAOImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ACERR
 */
public class InforServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InforServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InforServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private AccountDAOImpl aDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command != null && command.equals("information")) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // Đảm bảo username không null hoặc rỗng trước khi tìm tài khoản
            if (username != null && !username.isEmpty()) {
                Account account = aDAO.getInfoAccount(username);
                System.out.println(account.getLogin_Name());
                if (account != null) {
                    System.out.println(account);
                    session.setAttribute("Name_Account", account.getName_Account());
                    session.setAttribute("Login_Name", account.getLogin_Name());
                    session.setAttribute("ID_Account", account.getID_Account());
                    session.setAttribute("Status", account.getStatus());
                    System.out.println(account.getLogin_Name());
                    RequestDispatcher rd = request.getRequestDispatcher("/infor.jsp");
                    rd.forward(request, response);

                } else {
                    // Xử lý trường hợp không tìm thấy tài khoản
                    response.sendRedirect("login.jsp"); // Hoặc trang thông báo lỗi phù hợp
                }
            } else {
                // Nếu không có username trong session, chuyển hướng người dùng đến trang đăng nhập
                response.sendRedirect("login.jsp");
            }
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
        processRequest(request, response);
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
