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
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author ACERR
 */
public class UpdateAccountServlet extends HttpServlet {

    AccountDAOImpl AccountDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Nhận thông tin được gửi từ form HTML
        int ID_Account = Integer.parseInt(request.getParameter("ID_Account"));
        String TenAccount = request.getParameter("Name_Account");
        String TenDangNhap = request.getParameter("Login_Name");
        String MatKhau = request.getParameter("Password");
        int QuyenTruyCap = Integer.parseInt(request.getParameter("Access_rights"));

        // Lấy thông tin tài khoản hiện tại từ cơ sở dữ liệu
        Account currentAccount = AccountDAO.getAccountByIDAccount(ID_Account);

        if (!MatKhau.equals(currentAccount.getPassword())) {
            MatKhau = EncodePass.toSHA1(MatKhau);
            currentAccount.setPassword(MatKhau);
        }
        if (!TenAccount.equals(currentAccount.getName_Account())) {
            currentAccount.setName_Account(TenAccount);
        }
        if (!TenDangNhap.equals(currentAccount.getLogin_Name())) {
            currentAccount.setLogin_Name(TenDangNhap);
        }
        if (QuyenTruyCap != currentAccount.getAccess_rights()) {
            currentAccount.setAccess_rights(QuyenTruyCap);
        }

        // Cập nhật thông tin tài khoản
//        currentAccount.setName_Account(TenAccount);
//        currentAccount.setLogin_Name(TenDangNhap);
//        currentAccount.setPassword(MatKhau);
//        currentAccount.setAccess_rights(QuyenTruyCap);
        // Thực hiện cập nhật thông tin vào cơ sở dữ liệu
        AccountDAO.updateAccount(currentAccount);

        // Chuyển hướng về trang quản lý người dùng
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_user.jsp");
        rd.forward(request, response);
    }

}

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//
//        // Nhận thông tin được gửi từ form HTML
//        int ID_Account = Integer.parseInt(request.getParameter("ID_Account"));
//        String TenAccount = request.getParameter("Name_Account");
//        String TenDangNhap = request.getParameter("Login_Name");
//        String MatKhau = request.getParameter("Password");
//        int QuyenTruyCap = Integer.parseInt(request.getParameter("Access_rights"));
//
//        // Mã hóa mật khẩu
//        String encryptedPassword = EncodePass.toSHA1(MatKhau);
//
//        // Lấy thông tin tài khoản hiện tại từ cơ sở dữ liệu
//        Account currentAccount = AccountDAO.getAccountByIDAccount(ID_Account);
//
//        // Kiểm tra và cập nhật thông tin chỉ khi có sự thay đổi
//        if (!TenAccount.equals(currentAccount.getName_Account())) {
//            currentAccount.setName_Account(TenAccount);
//        }
//        if (!TenDangNhap.equals(currentAccount.getLogin_Name())) {
//            currentAccount.setLogin_Name(TenDangNhap);
//        }
//        if (!encryptedPassword.equals(currentAccount.getPassword())) {
//            currentAccount.setPassword(encryptedPassword);
//        }
//        if (QuyenTruyCap != currentAccount.getAccess_rights()) {
//            currentAccount.setAccess_rights(QuyenTruyCap);
//        }
//
//        // Thực hiện cập nhật thông tin vào cơ sở dữ liệu
//        AccountDAO.updateAccount(currentAccount);
//
//        // Chuyển hướng về trang quản lý người dùng
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_user.jsp");
//        rd.forward(request, response);
//    }
