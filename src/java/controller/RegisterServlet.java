/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import helpers.EncodePass;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author ACERR
 */
public class RegisterServlet extends HttpServlet {

    private AccountDAOImpl AccountDAO = new AccountDAOImpl();

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_tai_khoan = request.getParameter("LoginName");
        String ten_dang_nhap = request.getParameter("Username");
        String mat_khau = request.getParameter("Password");
        String ten_dang_nhap_err = "", ten_tai_khoan_err = "", mat_khau_err = "";
        if (ten_tai_khoan.equals("")) {
            ten_tai_khoan_err = "Vui lòng nhập Họ tên của bạn !";
        }
        if (ten_tai_khoan_err.length() > 0) {
            request.setAttribute("ten_tai_khoan_err", ten_tai_khoan_err);
        }
        if (ten_dang_nhap.equals("")) {
            ten_dang_nhap_err = "Vui lòng nhập Email của bạn";
        } else {
            if (AccountDAO.checkAccount(ten_dang_nhap) == true) {
                ten_dang_nhap_err = "Địa chỉ Email đã tồn tại";
            }
        }
        if (ten_dang_nhap_err.length() > 0) {
            request.setAttribute("ten_dang_nhap_err", ten_dang_nhap_err);
        }
        if (mat_khau.equals("")) {
            mat_khau_err = "Vui lòng nhập mật khẩu";
        }
        if (mat_khau_err.length() > 0) {
            request.setAttribute("mat_khau_err", mat_khau_err);
        }
        request.setAttribute("ten_tai_khoan", ten_tai_khoan);
        request.setAttribute("ten_dang_nhap", ten_dang_nhap);
        request.setAttribute("mat_khau", mat_khau);
        String url = "/account.jsp";
        try {
            if (mat_khau_err.length() == 0 && ten_dang_nhap_err.length() == 0 && ten_tai_khoan_err.length() == 0) {

                Account tk = new Account(ten_tai_khoan, ten_dang_nhap, EncodePass.toSHA1(mat_khau), 1);
                AccountDAO.insertAccount(tk);
                url = "/index.jsp";

            } else {
                url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

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
