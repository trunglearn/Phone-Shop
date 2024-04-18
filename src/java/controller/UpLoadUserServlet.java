/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAOImpl;
import helpers.EncodePass;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import helpers.EncodePass;

/**
 *
 * @author ACERR
 */
public class UpLoadUserServlet extends HttpServlet {

    AccountDAOImpl tkDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String TenAccount = request.getParameter("Name_Account");
        String TenDangNhap = request.getParameter("Login_Name");
        String MatKhau = request.getParameter("password");
        String QuyenTruyCap = request.getParameter("access_rights");
        String url = "";
        String TenAccount_err = "", TenDangNhap_err = "", MatKhau_err = "", QuyenTruyCap_err = "", TinhTrang_err = "";
        if (TenAccount.equals("")) {
            TenAccount_err = "Vui lòng nhập Họ tên ";
        }
        if (TenDangNhap_err.length() > 0) {
            request.setAttribute("TenAccount_err", TenAccount_err);
        }
        if (TenDangNhap.equals("")) {
            TenDangNhap_err = "Vui Lòng nhập Email";
        } else {
            if (tkDAO.checkAccount(TenDangNhap) == true) {
                TenDangNhap_err = "Địa chỉ Email đã tồn tại";
            }
        }
        if (TenDangNhap_err.length() > 0) {
            request.setAttribute("TenDangNhap_err", TenDangNhap_err);
        }
        if (MatKhau.equals("")) {
            MatKhau_err = "Vui lòng nhập mật khẩu";
        }
        if (MatKhau_err.length() > 0) {
            request.setAttribute("MatKhau_err", MatKhau_err);
        }
        if (QuyenTruyCap.equals("")) {
            QuyenTruyCap_err = "Vui lòng nhập quyền truy cập";
        }
        if (QuyenTruyCap_err.length() > 0) {
            request.setAttribute("QuyenTruyCap_err", QuyenTruyCap_err);
        }
       
        request.setAttribute("TenAccount", TenAccount);
        request.setAttribute("TenDangNhap", TenDangNhap);
        request.setAttribute("MatKhau", MatKhau);
        request.setAttribute("QuyenTruyCap", QuyenTruyCap);
      
        try {
            if (TenAccount_err.length() == 0 && TenDangNhap_err.length() == 0 && MatKhau_err.length() == 0 && QuyenTruyCap_err.length() == 0
                    && TinhTrang_err.length() == 0) {
                Account tk = new Account(TenAccount, TenDangNhap, EncodePass.toSHA1(MatKhau), Integer.parseInt(QuyenTruyCap));
                tkDAO.insertAccount(tk);
                url = "/admin/manager_user.jsp";
            } else {
                url = "/admin/insert_user.jsp";
            }

        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
