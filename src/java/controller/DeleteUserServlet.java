/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACERR
 */
public class DeleteUserServlet extends HttpServlet {
    AccountDAOImpl tkDAO= new AccountDAOImpl();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int ID_Account=Integer.parseInt(request.getParameter("ID_Account"));
        tkDAO.deleteAccount(ID_Account);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_user.jsp");
        rd.forward(request, response);
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   

}
